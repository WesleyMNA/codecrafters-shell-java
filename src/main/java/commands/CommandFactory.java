package commands;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static CommandFactory instance;
    private final Map<String, Command> builtins = new HashMap<>();

    private CommandFactory() {
        builtins.put("exit", new ExitCommand());
        builtins.put("echo", new EchoCommand());
    }

    public static CommandFactory getInstance() {
        if (instance == null)
            instance = new CommandFactory();

        return instance;
    }

    public void registerBuiltin(String name, Command command) {
        builtins.put(name, command);
    }

    public Command getBuiltin(String name) {
        return builtins.get(name);
    }

    public boolean contains(String command) {
        return builtins.containsKey(command);
    }
}
