package chat;

import java.io.*;
import java.net.Socket;

/**
 * chat
 *
 * @author raptor
 *         date: 17.03.16.
 */
public class ChatSocket extends Thread {
    private Socket socket;
//    private ChatServer chatServer;

    public ChatSocket(Socket socket) {
        this.socket = socket;
//        this.chatServer = chatServer;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            out.write("");
            while (true) {
                String msg = in.readLine();
                if (!"Bue.".equals(msg)) {
                    out.write(msg + "\n");
                    out.flush();
                } else {
//                    socket.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}