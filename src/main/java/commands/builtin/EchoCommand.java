package commands.builtin;

import prompt.PromptDto;

public class EchoCommand extends FileWriter implements BuiltinCommand {

    @Override
    public String name() {
        return "echo";
    }

    @Override
    public void execute(PromptDto input) {
        if (input.redirectStdout())
            write(input);
        else {
            if (input.redirectStderr())
                write(input, "");
            System.out.println(String.join(" ", input.args()));
        }
    }
}
