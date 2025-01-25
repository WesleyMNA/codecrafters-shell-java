package commands;

import commands.builtin.EchoCommand;
import commands.builtin.ExitCommand;
import commands.builtin.TypeCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandFactory {

    private final Map<String, Command> builtins = new HashMap<>();

    public CommandFactory() {
        builtins.put("exit", new ExitCommand());
        builtins.put("echo", new EchoCommand());
        builtins.put("type", new TypeCommand(this));
    }

    public Optional<Command> getCommand(String name) {
        Command command = builtins.get(name);
        return command != null
                ? Optional.of(command)
                : Optional.empty();
    }
}
