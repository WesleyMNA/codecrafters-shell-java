package commands.path;

import commands.Command;
import prompt.PromptDto;

import java.io.File;

public record PathCommand(
        String name,
        String location
) implements Command {

    @Override
    public void execute(PromptDto input) {
        var builder = createBuilder(input);

        try {
            Process process = builder.start();
            process.waitFor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private ProcessBuilder createBuilder(PromptDto input) {
        var builder = new ProcessBuilder();
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        builder.redirectError(ProcessBuilder.Redirect.INHERIT);
        builder.command(input.toPathCommand());

        if (input.redirectStdout())
            builder.redirectOutput(new File(input.redirectFilename()));
        return builder;
    }
}
