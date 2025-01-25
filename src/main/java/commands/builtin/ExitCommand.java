package commands.builtin;

import prompt.PromptDto;

public class ExitCommand implements BuiltinCommand {

    @Override
    public String name() {
        return "exit";
    }

    @Override
    public void execute(PromptDto input) {
        System.exit(Integer.parseInt(input.args().getFirst()));
    }
}
