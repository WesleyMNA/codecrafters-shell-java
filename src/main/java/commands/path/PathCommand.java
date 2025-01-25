package commands.path;

import commands.Command;
import prompt.PromptDto;

public record PathCommand(
        String name,
        String location
) implements Command {

    @Override
    public void execute(PromptDto input) {

    }
}
