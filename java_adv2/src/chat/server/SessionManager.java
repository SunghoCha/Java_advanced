package chat.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.util.MyLogger.log;

public class SessionManager {

    private final List<Session> sessions = new ArrayList<>();

    public void add(Session session) {
        sessions.add(session);
    }

    public void remove(Session session) {
        sessions.remove(session);
    }

    public void sendAll(String received) {
        for (Session session : sessions) {
            try {
                session.send(received);
            } catch (IOException e) {
                log(e);
            }
        }
    }

    public void closeAll() {
        for (Session session : sessions) {
            session.close();
        }
        sessions.clear();
    }

    public List<String> getUsers() {
        return sessions.stream().map(Session::getUsername).toList();
    }
}
