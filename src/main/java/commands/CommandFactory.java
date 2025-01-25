package commands;

import commands.builtin.EchoCommand;
import commands.builtin.ExitCommand;
import commands.builtin.TypeCommand;
import commands.path.PathCommandFinder;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandFactory {

    private final PathCommandFinder pathFinder;
    private final Map<String, Command> builtins = new HashMap<>();

    public CommandFactory() {
        var exitCommand = new ExitCommand();
        builtins.put(exitCommand.name(), exitCommand);
        var echoCommand = new EchoCommand();
        builtins.put(echoCommand.name(), echoCommand);
        var typeCommand = new TypeCommand(this);
        builtins.put(typeCommand.name(), typeCommand);
        this.pathFinder = new PathCommandFinder();
    }

    public Optional<Command> getCommand(String name) {
        Command command = builtins.get(name);
        return command != null
                ? Optional.of(command)
                : pathFinder.findCommand(name);
    }
}
