package domain;

import java.util.List;

public record CommandContext(
        String input,
        List<String> args
) {
}
