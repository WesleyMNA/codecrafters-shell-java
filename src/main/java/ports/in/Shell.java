package ports.in;

import domain.CommandResult;

public interface Shell {
    CommandResult execute(String input);
}
