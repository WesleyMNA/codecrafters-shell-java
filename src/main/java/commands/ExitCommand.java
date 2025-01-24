package commands;

import prompt.PromptDto;

class ExitCommand implements Command {

    @Override
    public void execute(PromptDto input) {
        System.exit(Integer.parseInt(input.args().getFirst()));
    }
}
