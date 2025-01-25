package prompt;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PromptInputTokenizer {

    private final String input;
    private StringBuilder builder;
    private boolean isInsideSingleQuotes;

    private final Set<Character> charactersToIgnore = Set.of('\'', '\"', ' ');

    public PromptInputTokenizer(String input) {
        this.input = input;
        this.builder = new StringBuilder();
        this.isInsideSingleQuotes = false;
    }

    public List<String> tokenize() {
        List<String> keywords = new ArrayList<>();

        for (int charIndex = 0; charIndex < input.length(); charIndex++) {
            char character = input.charAt(charIndex);

            if (character == '\'') {
                isInsideSingleQuotes = !isInsideSingleQuotes;
            } else if (isInsideSingleQuotes) {
                builder.append(character);
            } else if (!charactersToIgnore.contains(character)) {
                builder.append(character);
            } else if (!builder.isEmpty()) {
                keywords.add(builder.toString());
                builder = new StringBuilder();
            }
        }

        if (!builder.isEmpty())
            keywords.add(builder.toString());

        return keywords;
    }
}
