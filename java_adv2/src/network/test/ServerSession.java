package network.test;

import java.io.*;

import static io.util.MyLogger.log;

public class ServerSession implements Runnable {

    private final DataInputStream input;
    private final DataOutputStream output;
    private final SessionManager sessionManager;

    public ServerSession(InputStream input, OutputStream output, SessionManager sessionManager) {
        this.input = new DataInputStream(input);
        this.output = new DataOutputStream(output);
        this.sessionManager = sessionManager;
    }

    @Override
    public void run() {
            try {
                while (true) {
                    String received = input.readUTF();
                    log("received: " + received);

                    sessionManager.sendAll(received);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }

    public void send(String received) throws IOException {
        output.writeUTF(received);
    }
}
