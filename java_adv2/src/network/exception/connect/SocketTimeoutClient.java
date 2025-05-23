package network.exception.connect;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketTimeoutClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345);
        InputStream input = socket.getInputStream();
        try {
            socket.setSoTimeout(3000);
            int read = input.read(); // 무한 대기
            System.out.println("read = " + read);
        } catch (Exception e) {
            e.printStackTrace();
        }
        socket.close();
    }
}
