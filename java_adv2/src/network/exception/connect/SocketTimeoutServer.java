package network.exception.connect;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTimeoutServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket accept = serverSocket.accept();

        Thread.sleep(1000000);
    }
}
