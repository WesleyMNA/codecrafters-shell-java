package commands.builtin;

import models.WorkingDirectory;
import prompt.PromptDto;

import java.io.File;

public class CdCommand implements BuiltinCommand {

    private final WorkingDirectory workingDirectory;

    public CdCommand() {
        this.workingDirectory = WorkingDirectory.getInstance();
    }

    @Override
    public String name() {
        return "cd";
    }

    @Override
    public void execute(PromptDto input) {
        String dir = input.args().getFirst();

        if (new File(dir).isDirectory())
            workingDirectory.setCurrentDir(dir);
        else
            System.out.printf("cd: %s: No such file or directory%n", dir);
    }
}
