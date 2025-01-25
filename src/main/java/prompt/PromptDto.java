package prompt;

import java.util.List;

public record PromptDto(
        String command,
        List<String> args,
        List<String> keywords
) {
}
