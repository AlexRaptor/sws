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
    private ChatServer chatServer;

    private BufferedReader in;
    private PrintWriter out;

    public ChatSocket(ChatServer chatServer, Socket socket) throws IOException {
        this.socket = socket;
        this.chatServer = chatServer;

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // Включаем автоматическое выталкивание
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String str = in.readLine();
                if ("Bue.".equals(str)) {
                    break;
                }
                System.out.println("Echoing: " + str);
                out.println(str);
            }
            System.out.println("closing...");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Socket not closed");
                e.printStackTrace();
            }
        }
    }
}