package network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ConnectTimeoutMain2 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        try {
            Socket socket = new Socket(); // 사설 IP 대역(주로 공유기에서 사용하는 IP 대역)
            socket.connect(new InetSocketAddress("192.168.1.250", 45678), 1000);
        } catch (ConnectException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");

    }
}
