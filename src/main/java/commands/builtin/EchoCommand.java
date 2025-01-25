package commands.builtin;

import prompt.PromptDto;

public class EchoCommand implements BuiltinCommand {

    @Override
    public String name() {
        return "echo";
    }

    @Override
    public void execute(PromptDto input) {
        System.out.println(String.join(" ", input.args()));
    }
}
