package network.tcp.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static io.util.MyLogger.log;

public class ServerV1 {

    public static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT); // 단지 클라이언트와 서버의 TCP 연결만 지원하는 특별한 소켓
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        Socket socket = serverSocket.accept();
        /*
            accept()를 호출하면 backlog queue에서 TCP 연결 정보를 조회한다.
            (만약 TCP 연결 정보가 없다면, 연결 정보가 생성될 때까지 대기한다. (블로킹)
            해당 정보를 기반으로 Socket 객체를 생성한다.
            사용한 TCP 연결 정보는 backlog queue에서 제거된다.
         */
        log("소켓 연결");
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        // 클라이언트로부터 문자 받기
        String received = input.readUTF();
        log("client -> server: " + received);

        // 클라이언트에 문자 보내기
        String toSend = received + " World";
        output.writeUTF(toSend);
        log("client <- server: " + toSend);

        // 자원정리
        log("연결 종료: " + socket);
        input.close();
        output.close();
        socket.close();
        serverSocket.close();
    }
}
