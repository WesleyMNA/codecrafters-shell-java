package domain.commands;

import domain.CommandContext;
import domain.CommandExistenceValidator;
import domain.CommandResult;

public class TypeCommand implements Command {

    private final CommandExistenceValidator validator;

    public TypeCommand(CommandExistenceValidator validator) {
        this.validator = validator;
    }

    @Override
    public String name() {
        return "type";
    }

    @Override
    public CommandResult execute(CommandContext context) {
        String commandToSearch = context.args().getFirst();
        boolean commandExists = validator.exists(commandToSearch);
        String stdout = commandExists
                ? "%s is a shell builtin"
                : "%s: not found";
        return new CommandResult(
                stdout.formatted(commandToSearch),
                false
        );
    }
}
