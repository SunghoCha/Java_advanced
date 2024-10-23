package chat.server.impl;

import chat.server.CommandManager;
import chat.server.Session;
import chat.server.SessionManager;

import java.io.IOException;

public class CommandManagerV1 implements CommandManager {

    private final SessionManager sessionManager;

    public CommandManagerV1(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {
        if (totalMessage.startsWith("/exit")) {
            throw new IOException("exit"); // session이 해당 에외를 잡아서 세션 종료
        }
        sessionManager.sendAll(totalMessage);
    }
}
