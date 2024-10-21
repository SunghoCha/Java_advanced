package network.tcp.v4;

import network.tcp.SocketCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static io.util.MyLogger.log;

public class ClientV4 {

    public static final int PORT = 12345;

    public static void main(String[] args) {
        log("클라이언트 시작");
        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream output = null;

        try {
            socket = new Socket("localhost", PORT);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            log("소캣 연결: " + socket);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("전송 문자: ");
                String toSend = scanner.nextLine();

                // 서버에게 문자 보내기
                output.writeUTF(toSend);
                log("client -> server: " + toSend);

                if (toSend.equals("exit")) {
                    break;
                }
                // 서버로부터 문자 받기
                String received = input.readUTF();
                log("client <- server: " + received);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            // 자원 정리
            SocketCloseUtil.closeAll(socket, input, output);
            log("연결 종료: " + socket);
        }

    }
}