package HW26;

import HW24_JDBC.HeroDaoImplementation;
import HW25_Patterns_Integration_Testing.HeroMovieService;
import HW25_Patterns_Integration_Testing.HeroService;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class HeroProtocol {
    public static void run(Socket socket) throws IOException {
        while (true) {
            var out = new PrintWriter(socket.getOutputStream(), true);
            var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message = in.readLine();

            if (message.equals("-exit")) {
                System.out.println("Client disconnected");
                in.close();
                out.close();
                socket.close();
                break;
            }
            if (message.startsWith("-name")) {
                System.out.println("Finding request");
                String heroName = message.substring(5);

                HeroService heroService = new HeroService(new HeroDaoImplementation(dataSource()), new HeroMovieService());
                var heroDao = new HeroDaoImplementation(dataSource()).findByName(heroName);
                var hero = heroService.map(heroDao.get(0));

                if (hero.equals(null)) {
                    System.out.println("Hero is not found");
                } else {
                System.out.println(hero);
                }
            }
        }
    }
    private static DataSource dataSource() {
        var ds = new PGSimpleDataSource();
        ds.setServerNames(new String[]{"localhost"});
//        ds.setDatabaseName("postgres");
        ds.setUser("hillel");
        ds.setPassword("hillel");
        return ds;
    }
}
