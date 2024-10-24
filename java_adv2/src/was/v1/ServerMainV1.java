package was.v1;

import java.io.IOException;

public class ServerMainV1 {

    public static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        HttpServerV1 server = new HttpServerV1(PORT);
        server.start();
    }
}
