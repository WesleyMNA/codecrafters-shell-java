package commands.path;

import commands.Command;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;

public class PathCommandFinder {

    private final String path;

    public PathCommandFinder() {
        this.path = System.getenv("PATH");
    }

    public Optional<Command> findCommand(String command) {
        if (Objects.nonNull(path)) {
            String[] folders = path.split(":");

            for (String folder : folders) {
                var commandPath = Path.of(folder, command);
                boolean exists = Files.exists(commandPath);

                if (exists)
                    return Optional.of(
                            new PathCommand(command, commandPath.toString())
                    );
            }
        }

        return Optional.empty();
    }
}
