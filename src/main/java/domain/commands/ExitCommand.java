package domain.commands;

import domain.CommandContext;
import domain.CommandResult;

public class ExitCommand implements Command {
    @Override
    public String name() {
        return "exit";
    }

    @Override
    public CommandResult execute(CommandContext context) {
        return new CommandResult(
                null,
                true
        );
    }
}
