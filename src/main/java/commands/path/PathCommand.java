package commands.path;

import commands.Command;
import prompt.PromptDto;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public record PathCommand(
        String name,
        String location
) implements Command {

    @Override
    public void execute(PromptDto input) {
        var builder = new ProcessBuilder();
        builder.command(input.keywords());

        try {
            Process process = builder.start();

            try (var reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null)
                    System.out.println(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
