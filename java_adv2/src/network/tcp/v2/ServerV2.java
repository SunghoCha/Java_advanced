package network.tcp.v2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static io.util.MyLogger.log;

public class ServerV2 {

    public static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        // 서버 소켓 생성
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        // accept()해서 소켓 생성
        Socket socket = serverSocket.accept(); // 블로킹 상태로 연결정보 생성까지 대기
        log("소켓 연결: " + socket);

        // 소켓의 인풋스트림, 아웃풋스트림.
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        // while문 input에서 데이터 꺼내는데 exit면 종료.
        while (true) {
            String received = input.readUTF();
            log("client -> server: " + received);

            // 클라이언트 종료시 서버도 함께 종료
            if (received.equals("exit")) {
                break;
            }
            // 클라이언트에 문자 보내기
            String toSend = received + " World";
            output.writeUTF(toSend);
            log("client <- server: " + toSend);
        }
        // 자원정리
        log("연결 종료: " + socket);
        input.close();
        output.close();
        socket.close();
        serverSocket.close();
    }
}
