package application;

import domain.CommandExistenceValidator;
import domain.commands.*;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory implements CommandExistenceValidator {

    private final Map<String, Command> commands;

    public CommandFactory() {
        this.commands = new HashMap<>();
        this.add(new ExitCommand());
        this.add(new EchoCommand());
        this.add(new TypeCommand(this));
    }

    private void add(Command command) {
        this.commands.put(command.name(), command);
    }

    public Command create(String input) {
        return commands.getOrDefault(input, new CommandNotFound());
    }

    @Override
    public boolean exists(String input) {
        return commands.containsKey(input);
    }
}
