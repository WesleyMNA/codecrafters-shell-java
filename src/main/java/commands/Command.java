package commands;

import prompt.PromptDto;

public interface Command {

    void execute(PromptDto input);
}
