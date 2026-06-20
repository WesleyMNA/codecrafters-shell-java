package application;

import domain.CommandContext;

import java.util.List;

public class InputParser {

    public CommandContext parse(String input) {
        String[] parts = input.split("\\s+");
        String command = parts[0];
        String[] args = new String[parts.length - 1];
        System.arraycopy(parts, 1, args, 0, args.length);
        return new CommandContext(command, List.of(args));
    }
}
