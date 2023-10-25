package HW26;

import HW24_JDBC.HeroDaoImplementation;
import HW25_Patterns_Integration_Testing.HeroMovieService;
import HW25_Patterns_Integration_Testing.HeroService;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HeroClient {
    private final static int SERVER_PORT = 8080;
    private static ServerSocket server;
     public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
            try(Socket socket = new Socket(HeroProtocol.SERVER_HOST, 8080)){
                BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));
                var out = new PrintWriter(socket.getOutputStream(), true);
                var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                while(true){
                String message = (String) in.readLine();
                System.out.println("Message: " + message);
                consoleIn.close();
                out.close();
                Thread.sleep(100);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
    }
}
