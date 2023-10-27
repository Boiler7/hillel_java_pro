package HW26;

import HW24_JDBC.HeroDaoImplementation;
import HW25_Patterns_Integration_Testing.HeroMovieService;
import HW25_Patterns_Integration_Testing.HeroService;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HeroServer {
    private final static int SERVER_PORT = 8080;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException, ClassNotFoundException, IOException {
        var server = new ServerSocket(SERVER_PORT);
        while (true) {
            System.out.println("Waiting for the client request");
            var socket = server.accept();
            var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message = in.readLine();
            var out = new PrintWriter(socket.getOutputStream(), true);

            in.close();
            out.close();
            socket.close();
            if (message.equalsIgnoreCase("-exit")) {
                break;
            } else if (message.contains("-name")) {
                HeroService heroService = new HeroService(new HeroDaoImplementation(dataSource()), new HeroMovieService());
                String[] separated = message.split(" ");
                var heroDao = new HeroDaoImplementation(dataSource()).findByName(separated[1]);
                if (heroDao == null) {

                } else {

                }
            }
        }
        System.out.println("Shutting down Socket server");
        server.close();
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
