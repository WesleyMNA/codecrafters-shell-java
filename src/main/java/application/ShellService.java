package application;

import domain.CommandContext;
import domain.CommandResult;
import ports.in.Shell;

public class ShellService implements Shell {

    private final CommandFactory factory;
    private final InputParser parser;

    public ShellService() {
        this.factory = new CommandFactory();
        this.parser = new InputParser();
    }

    @Override
    public CommandResult execute(String input) {
        CommandContext context = parser.parse(input);
        return factory
                .create(context.input())
                .execute(context);
    }
}
