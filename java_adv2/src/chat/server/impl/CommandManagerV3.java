package chat.server.impl;

import chat.server.CommandManager;
import chat.server.Session;
import chat.server.SessionManager;
import chat.server.command.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator;

public class CommandManagerV3 implements CommandManager {

    public static final String DELIMITER = "|";
    private final Map<String, Command> commands = new HashMap<>();
    private final Command defaultCommand = new DefaultCommand();

    public CommandManagerV3(SessionManager sessionManager) {
        commands.put("/join", new JoinCommand(sessionManager));
        commands.put("/message", new MessageCommand(sessionManager));
        commands.put("/change", new ChangeCommand(sessionManager));
        commands.put("/users", new UsersCommand(sessionManager));
        commands.put("/exit", new ExitCommand());
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {
        String[] args = totalMessage.split(DELIMITER, 2);
        String key = args[0];
        
        Command command = commands.getOrDefault(key, defaultCommand);
        command.execute(args, session);
    }
}
