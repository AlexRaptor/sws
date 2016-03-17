package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * chat
 *
 * @author raptor
 *         date: 17.03.16.
 */
public class ChatServer {
    private int port;
    private int size;

    public ChatServer(int port, int size) throws IOException {
        this.port = port;
        this.size = size;
    }

    public void start() {
        for (int i = 0; i < size; i++) {
            try {
                new ChatSocket(new ServerSocket(port).accept()).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
