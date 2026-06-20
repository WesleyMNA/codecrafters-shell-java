package application;

import domain.CommandContext;
import domain.CommandResult;
import ports.in.Shell;

public class ShellService implements Shell {

    private final CommandFactory factory;

    public ShellService() {
        this.factory = new CommandFactory();
    }

    @Override
    public CommandResult execute(String input) {
        return factory
                .create(input)
                .execute(new CommandContext(input));
    }
}
