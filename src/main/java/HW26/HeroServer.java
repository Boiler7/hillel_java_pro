package HW26;

import HW24_JDBC.HeroDaoImplementation;
import HW25_Patterns_Integration_Testing.HeroMovieService;
import HW25_Patterns_Integration_Testing.HeroService;
import HW7_Exceptions.ArraySizeException;
import org.postgresql.ds.PGSimpleDataSource;
import javax.sql.DataSource;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HeroServer {
    private final static int SERVER_PORT = 8080;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException, ClassNotFoundException, IOException {
        server = new ServerSocket(SERVER_PORT);

        var socket = server.accept();
        var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        var out = new PrintWriter(socket.getOutputStream(), true);

        while (true) {

            System.out.println("Waiting for the client request");

            String message = in.readLine();


            if (message.equalsIgnoreCase("-exit")) {
                System.out.println("Shutting down the server");
                in.close();
                out.close();
                socket.close();
                server.close();
                break;
            } else if (message.startsWith("-name")) {
                System.out.println("Finding request");
                message = message.substring(5);
                out.println("ldkjfs" + message);

                HeroService heroService = new HeroService(new HeroDaoImplementation(dataSource()), new HeroMovieService());
                var heroDao = new HeroDaoImplementation(dataSource()).findByName(message);

                if (heroDao == null) {
                    out.println("Hero is not found");
                } else {

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
