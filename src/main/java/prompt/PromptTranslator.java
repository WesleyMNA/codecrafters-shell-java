package prompt;

import java.util.List;

public class PromptTranslator {

    private final List<String> keywords;

    public PromptTranslator(List<String> keywords) {
        this.keywords = keywords;
    }

    public PromptDto translate() {
        String command = keywords.getFirst();
        return new PromptDto(
                command,
                keywords.subList(1, keywords.size())
        );
    }
}
