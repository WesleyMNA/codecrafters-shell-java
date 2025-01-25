package commands;

import prompt.PromptDto;

public class TypeCommand implements Command {

    private final CommandFactory factory;

    public TypeCommand(CommandFactory factory) {
        this.factory = factory;
    }

    @Override
    public void execute(PromptDto input) {
        String arg = input.args().getFirst();
        boolean contains = factory.contains(arg);

        if (contains)
            System.out.printf("%s is a shell builtin%n", arg);
        else
            System.out.printf("%s: not found%n", arg);
    }
}
