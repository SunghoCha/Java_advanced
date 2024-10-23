package network.test;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import static io.util.MyLogger.log;

public class ClientSession implements Runnable {

    private final DataInputStream input;

    public ClientSession(InputStream inputStream) {
        this.input = new DataInputStream(inputStream);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = input.readUTF();
                log("server -> client: " + received);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
