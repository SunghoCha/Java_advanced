package network.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SessionManager {

    private final List<ServerSession> sessions = new ArrayList<>();

    public void add(ServerSession serverSession) {
        sessions.add(serverSession);
    }

    public void sendAll(String received) throws IOException {
        for (ServerSession session : sessions) {
            session.send(received);
        }
    }
}
