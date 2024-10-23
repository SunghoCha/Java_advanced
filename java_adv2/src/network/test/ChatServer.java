package network.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static io.util.MyLogger.log;

public class ChatServer {

    private static final SessionManager sessionManager = new SessionManager();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);

        while (true) {
            Socket socket = serverSocket.accept();
            ServerSession serverSession = new ServerSession(socket.getInputStream(), socket.getOutputStream(), sessionManager);
            sessionManager.add(serverSession);
            log("sessionManager에 추가: " + serverSession);

            Thread thread = new Thread(serverSession);
            thread.start();
        }

    }
}
