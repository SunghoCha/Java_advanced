package chat.server.impl;

import chat.server.CommandManager;
import chat.server.Session;
import chat.server.SessionManager;

import java.io.IOException;
import java.util.List;

public class CommandManagerV2 implements CommandManager {

    public static final String DELIMITER = "|";
    private final SessionManager sessionManager;

    public CommandManagerV2(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {
        if (totalMessage.startsWith("/join")) {
            String[] parts = totalMessage.split(DELIMITER, 2);
            String username = parts[1];
            session.setUsername(username);
            sessionManager.sendAll(username + "님이 입장했습니다.");

        }else if (totalMessage.startsWith("/message")) {
            String[] parts = totalMessage.split(DELIMITER, 2);
            String message = parts[1];
            sessionManager.sendAll("[" + session.getUsername() + "]" + message);

        } else if (totalMessage.startsWith("/change")) {
            String[] parts = totalMessage.split(DELIMITER, 2);
            String changeName = parts[1];
            sessionManager.sendAll(session.getUsername() + " -> " + changeName + "으로 변경");
            session.setUsername(changeName);

        } else if (totalMessage.startsWith("/users")) {
            List<String> users = sessionManager.getUsers();
            StringBuilder sb = new StringBuilder();
            sb.append("전체 접속자: ").append(users.size()).append("\n");
            for (String user : users) {
                sb.append("-").append(user).append("\n");
            }
            session.send(sb.toString());

        } else if (totalMessage.startsWith("/exit")) {
            throw new IOException("exit");

        } else {
            session.send("처리할 수 없는 명령어 입니다: " + totalMessage);
        }
    }
}
