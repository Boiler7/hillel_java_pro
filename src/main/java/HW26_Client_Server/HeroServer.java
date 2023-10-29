package HW26_Client_Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HeroServer {
    public final static String SERVER_HOST = "localhost";
    public final static int SERVER_PORT = 8080;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        server = new ServerSocket(SERVER_PORT);
        Socket socket = server.accept();

        var executor = Executors.newFixedThreadPool(2);

        Future<?> runnableFuture = executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    HeroProtocol.run(socket);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }finally {
                    try{
                        socket.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        while (true) {
            System.out.println("Waiting for the client request");

            var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            runnableFuture.get();
            String message = " ";

            message = in.readLine();
            if (message.equals("-exit")) {
                in.close();
                socket.close();
                server.close();
                break;
            }
        }
    }
}
