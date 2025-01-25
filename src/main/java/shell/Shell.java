package shell;

import commands.CommandFactory;
import prompt.PromptDto;
import prompt.PromptInputTokenizer;
import prompt.PromptTranslator;

import java.util.List;
import java.util.Scanner;

public class Shell {

    private final CommandFactory commandFactory;

    public Shell(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void startRepl() {
        var scanner = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty())
                continue;

            List<String> keywords = new PromptInputTokenizer(input).tokenize();
            PromptDto prompt = new PromptTranslator(keywords).translate();
            commandFactory
                    .getCommand(prompt.command())
                    .ifPresentOrElse(
                            command -> command.execute(prompt),
                            () -> System.out.println(prompt.command() + ": command not found")
                    );
        }
    }
}
