package hw26.client.server;

import hw24.jdbc.HeroDaoImplementation;
import hw25.patterns.integration.testing.HeroMovieService;
import hw25.patterns.integration.testing.HeroService;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HeroProtocol {
    public static void run(Socket socket) throws IOException {
            var out = new PrintWriter(socket.getOutputStream(), true);
            var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message;

        while (true) {
            message = in.readLine();

            if (message.equals("-exit")) {
                System.out.println("Client disconnected");
                in.close();
                out.close();
                break;
            }

            if (message.startsWith("-name")) {
                System.out.println("Finding request");
                String heroName = message.substring(6);

                HeroService heroService = new HeroService(new HeroDaoImplementation(dataSource()), new HeroMovieService());
                var heroDao = new HeroDaoImplementation(dataSource());
                var hero = heroDao.findByName(heroName).get(0);
                System.out.println("Hero's name: " + hero.getName());

                var herodto = heroService.map(hero);
                if (herodto.getMovies() == null & herodto.getName() == null) {
                    out.println("Hero is not found");
                } else {
                    System.out.println("Send hero");
                    out.println("Name:" +herodto.getName() + "\tMovies: " + herodto.getMovies());
                }
            }
        }
    }

    private static DataSource dataSource() {
        var ds = new PGSimpleDataSource();
        ds.setServerNames(new String[]{"localhost"});
        ds.setDatabaseName("postgres");
        ds.setUser("hillel");
        ds.setPassword("hillel");
        return ds;
    }
}