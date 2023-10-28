package HW26;

import HW24_JDBC.HeroDaoImplementation;
import HW25_Patterns_Integration_Testing.HeroMovieService;
import HW25_Patterns_Integration_Testing.HeroService;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HeroClient {
    private static ServerSocket server;

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        try (Socket socket = new Socket(HeroProtocol.SERVER_HOST, HeroProtocol.SERVER_PORT)) {
            Scanner scanner = new Scanner(System.in);
            var out = new PrintWriter(socket.getOutputStream(), true);
            var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                String message = scanner.next();
                out.println(message);
                if(message.equals("-exit")){
                    System.out.println("Shutting down the server");
                    in.close();
                    out.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
