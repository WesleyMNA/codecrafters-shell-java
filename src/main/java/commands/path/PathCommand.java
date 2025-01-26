package commands.path;

import commands.Command;
import prompt.PromptDto;
import prompt.PromptRedirect;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

        if (input.stdout().enabled()) {
            var file = new File(input.redirectFilename());

            if (input.stdout().append())
                builder.redirectOutput(ProcessBuilder.Redirect.appendTo(file));
            else
                builder.redirectOutput(file);
        } else if (input.stderr().enabled()) {
            var file = new File(input.redirectFilename());

            if (input.stdout().append())
                builder.redirectError(ProcessBuilder.Redirect.appendTo(file));
            else
                builder.redirectError(file);
        }

        return builder;
    }
}
