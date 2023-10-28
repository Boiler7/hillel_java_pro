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
    public final static String SERVER_HOST = "localhost";
    public final static int SERVER_PORT = 8080;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        server = new ServerSocket(SERVER_PORT);

        while (true) {
            System.out.println("Waiting for the client request");

            Socket socket = server.accept();

            var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            var out = new PrintWriter(socket.getOutputStream(), true);

            String message;

            message = in.readLine();
            if (message.equals("-exit"))
                break;

            Thread thread = new Thread(() -> {
                try {
                    HeroProtocol.run(socket);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
        }
    }

}