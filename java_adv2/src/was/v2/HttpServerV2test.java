package was.v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static io.util.MyLogger.log;
import static java.nio.charset.StandardCharsets.UTF_8;

public class HttpServerV2test {

    private final int port;

    public HttpServerV2test(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        log("서버 시작 port: " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            //process(socket);
            Task task = new Task(socket);
            Thread thread = new Thread(task);
            thread.start();
        }
    }

    static class Task implements Runnable {

        private final Socket socket;

        public Task(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (socket;
                 BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), false, UTF_8)) {
                String requestString = requestToString(reader);
                if (requestString.contains("/favicon.ico")) {
                    return;
                }
                log("HTTP 요청 정보 출력");
                System.out.println(requestString);

                log("HTTP 응답 생성 중...");
                Thread.sleep(5000);
                responseToClient(writer);
            } catch (IOException | InterruptedException e) {
                log(e);
            }
        }


        private void process(Socket socket) throws IOException {
            try (socket;
                 BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), false, UTF_8)) {
                String requestString = requestToString(reader);
                if (requestString.contains("/favicon.ico")) {
                    return;
                }
                log("HTTP 요청 정보 출력");
                System.out.println(requestString);

                log("HTTP 응답 생성 중...");
                Thread.sleep(5000);
                responseToClient(writer);
            } catch (InterruptedException e) {
                log(e);
            }
        }

        private void responseToClient(PrintWriter writer) {
            String body = "<h1>Hello World</h1>";
            int length = body.getBytes(UTF_8).length;

            StringBuilder sb = new StringBuilder();
            sb.append("HTTP/1.1 200 OK\r\n");
            sb.append("Content-Type: text/html\r\n");
            sb.append("Content-Length: ").append(length).append("\r\n");
            sb.append("\r\n");
            sb.append(body);

            log("HTTP 응답 정보 출력");
            System.out.println(sb);

            writer.println(sb);
            writer.flush(); // autoFlush false 설정이므로 반드시 flush 해줘야함
        }

        private String requestToString(BufferedReader reader) throws IOException {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) { // get 요청일때 헤더와 바디 구분 empty line 까지만 읽음
                    break;
                }
                sb.append(line).append("\n");
            }
            return sb.toString();
        }
    }
}
