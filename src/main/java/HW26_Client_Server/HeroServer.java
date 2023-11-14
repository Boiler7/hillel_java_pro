package HW26_Client_Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

public class HeroServer {
    public final static String SERVER_HOST = "localhost";
    public final static int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {
        var executor = Executors.newFixedThreadPool(2);
        var server = new ServerSocket(SERVER_PORT);
        while (true) {
            Socket socket = server.accept();
            executor.submit(new HeroHandler(socket));
        }
    }
}