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
    private ServerSocket serverSocket;
    private boolean finished;

    public ChatServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        finished = false;
        System.out.println("Server started");
    }

    public void start() throws IOException {
        Socket socket;
        try{
            while (!finished) {
                socket = serverSocket.accept();
                new ChatSocket(this, socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }

    public void finish() {
        finished = true;
    }
}
