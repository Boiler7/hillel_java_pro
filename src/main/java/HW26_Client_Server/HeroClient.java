package HW26_Client_Server;

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
                System.out.println("Enter a command: ");
                String message = scanner.nextLine();
                out.println(message);

                if(message.equals("-exit")){
                    System.out.println("Shutting down the connection...");
                    in.close();
                    out.close();
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