package application;

import domain.commands.Command;
import domain.commands.CommandNotFound;
import domain.commands.ExitCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private final Map<String, Command> commands;

    public CommandFactory() {
        this.commands = new HashMap<>();
        var exit = new ExitCommand();
        this.commands.put(exit.name(), exit);
    }

    public Command create(String input) {
        return commands.getOrDefault(input, new CommandNotFound());
    }
}
