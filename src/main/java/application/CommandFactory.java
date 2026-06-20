package application;

import domain.commands.Command;
import domain.commands.CommandNotFound;
import domain.commands.EchoCommand;
import domain.commands.ExitCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private final Map<String, Command> commands;

    public CommandFactory() {
        this.commands = new HashMap<>();
        this.add(new ExitCommand());
        this.add(new EchoCommand());
    }

    private void add(Command command) {
        this.commands.put(command.name(), command);
    }

    public Command create(String input) {
        return commands.getOrDefault(input, new CommandNotFound());
    }
}
