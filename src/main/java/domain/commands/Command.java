package domain.commands;

import domain.CommandContext;
import domain.CommandResult;

public interface Command {

    String name();

    CommandResult execute(CommandContext context);
}
