package chat.server;

import chat.server.impl.CommandManagerV1;

import java.io.IOException;

public class ServerMain {

    public static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        SessionManager sessionManager = new SessionManager();
        CommandManager commandManager = new CommandManagerV1(sessionManager);

        Server server = new Server(PORT, commandManager, sessionManager);
        server.start();
    }
}
