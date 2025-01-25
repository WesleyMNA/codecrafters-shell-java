package commands.builtin;

import prompt.PromptDto;

public class EchoCommand implements Builtin {

    @Override
    public void execute(PromptDto input) {
        System.out.println(String.join(" ", input.args()));
    }
}
