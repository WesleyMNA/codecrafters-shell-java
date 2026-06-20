package domain.commands;

import domain.CommandContext;
import domain.CommandResult;

public class CommandNotFound implements Command {
    @Override
    public String name() {
        return "";
    }

    @Override
    public CommandResult execute(CommandContext context) {
        return new CommandResult(
                "%s: command not found".formatted(context.input()),
                false
        );
    }
}
