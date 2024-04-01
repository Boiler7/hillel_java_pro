package hw26.client.server;

import java.io.IOException;
import java.net.Socket;

public class HeroHandler implements Runnable{
    private final Socket socket;

    public HeroHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Start");
            HeroProtocol.run(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
