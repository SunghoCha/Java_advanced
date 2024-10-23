package chat.server;

import chat.server.impl.CommandManagerV1;
import chat.server.impl.CommandManagerV2;
import chat.server.impl.CommandManagerV3;

import java.io.IOException;

public class ServerMain {

    public static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        SessionManager sessionManager = new SessionManager();
        //CommandManager commandManager = new CommandManagerV1(sessionManager);
        //CommandManager commandManager = new CommandManagerV2(sessionManager);
        CommandManager commandManager = new CommandManagerV3(sessionManager);

        Server server = new Server(PORT, commandManager, sessionManager);
        server.start();
    }
}
