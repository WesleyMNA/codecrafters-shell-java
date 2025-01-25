package commands.builtin;

import commands.CommandFactory;
import prompt.PromptDto;

public class TypeCommand implements Builtin {

    private final CommandFactory factory;

    public TypeCommand(CommandFactory factory) {
        this.factory = factory;
    }

    @Override
    public void execute(PromptDto input) {
        String arg = input.args().getFirst();
        factory
                .getCommand(arg)
                .ifPresentOrElse(
                        command -> System.out.printf("%s is a shell builtin%n", arg),
                        () -> System.out.printf("%s: not found%n", arg)
                );
    }
}
