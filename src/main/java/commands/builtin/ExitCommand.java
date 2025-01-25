package commands.builtin;

import prompt.PromptDto;

public class ExitCommand implements Builtin {

    @Override
    public void execute(PromptDto input) {
        System.exit(Integer.parseInt(input.args().getFirst()));
    }
}
