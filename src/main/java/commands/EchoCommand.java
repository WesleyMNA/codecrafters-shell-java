package commands;

import prompt.PromptDto;

class EchoCommand implements Command {

    @Override
    public void execute(PromptDto input) {
        System.out.println(String.join(" ", input.args()));
    }
}
