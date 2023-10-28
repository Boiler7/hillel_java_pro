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
    public static void main(String[] args)  {
        try (Socket socket = new Socket(HeroServer.SERVER_HOST, HeroServer.SERVER_PORT)) {
            Scanner scanner = new Scanner(System.in);
            var out = new PrintWriter(socket.getOutputStream(), true);
            var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                String message = scanner.nextLine();
                out.println(message);

                if(message.equals("-exit")){
                    System.out.println("Shutting down the connection...");
                    in.close();
                    out.close();
                    socket.close();
                    break;
                }
                String messageFromServer = in.readLine();
                System.out.println("Server: " + (messageFromServer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}