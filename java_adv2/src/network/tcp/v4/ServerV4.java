package network.tcp.v4;

import network.tcp.v3.SessionV3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static io.util.MyLogger.log;

public class ServerV4 {

    public static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        // 서버 소켓 생성
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        // accept()로 소켓 생성
        // 생성된 소켓으로 세션 객체 생성하고 start()
        while (true) {
            Socket socket = serverSocket.accept(); // 블로킹
            log("소켓 연결: " + socket);

            SessionV4 session = new SessionV4(socket);
            Thread thread = new Thread(session);
            thread.start();
        }
    }
}
