package domain.commands;

import domain.CommandContext;
import domain.CommandResult;

public class EchoCommand implements Command {
    @Override
    public String name() {
        return "echo";
    }

    @Override
    public CommandResult execute(CommandContext context) {
        return new CommandResult(
                String.join(" ", context.args()),
                false
        );
    }
}
