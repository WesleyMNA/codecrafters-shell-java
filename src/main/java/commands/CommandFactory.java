package commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandFactory {

    private static CommandFactory instance;
    private final Map<String, Command> builtins = new HashMap<>();

    private CommandFactory() {
        builtins.put("exit", new ExitCommand());
        builtins.put("echo", new EchoCommand());
        builtins.put("type", new TypeCommand(this));
    }

    public static CommandFactory getInstance() {
        if (instance == null)
            instance = new CommandFactory();

        return instance;
    }

    public void registerBuiltin(String name, Command command) {
        builtins.put(name, command);
    }

    public Optional<Command> getCommand(String name) {
        Command command = builtins.get(name);
        return command != null
                ? Optional.of(command)
                : Optional.empty();
    }

    public boolean contains(String command) {
        return builtins.containsKey(command);
    }
}
