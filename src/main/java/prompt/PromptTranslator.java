package prompt;

import java.util.List;
import java.util.Optional;

public class PromptTranslator {

    private final List<String> keywords;
    private String redirectFilename;
    private boolean redirectStdout;
    private boolean redirectStderr;

    public PromptTranslator(List<String> keywords) {
        this.keywords = keywords;
        this.redirectFilename = null;
        this.redirectStdout = false;
        this.redirectStderr = false;
    }

    public PromptDto translate() {
        Optional<String> redirectKey = keywords
                .stream()
                .filter(keyword -> keyword.endsWith(">"))
                .findAny();
        List<String> args = keywords.subList(1, keywords.size());

        if (redirectKey.isPresent()) {
            String redirectValue = redirectKey.get();
            redirectStdout = redirectValue.startsWith(">") || redirectValue.startsWith("1>");
            redirectStderr = redirectValue.startsWith("2>");
            redirectFilename = keywords.getLast();
            args = args.subList(0, args.size() - 2);
        }

        String command = keywords.getFirst();
        return new PromptDto(
                command,
                args,
                redirectStdout,
                redirectStderr,
                redirectFilename
        );
    }
}
