package network.test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import static io.util.MyLogger.log;

public class ChatClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost", 12345), 3000);

        // 서버로부터 실시간 채팅 내용 받기
        ClientSession clientSession = new ClientSession(socket.getInputStream());
        Thread thread = new Thread(clientSession);
        thread.start();

        while (true) {
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            // 문자입력
            System.out.println("전송문자 입력: ");
            String toSend = scanner.nextLine();
            // 서버로 전송
            output.writeUTF(toSend);
            log("client -> server: " + toSend);
        }
    }
}
