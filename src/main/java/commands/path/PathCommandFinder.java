package commands.path;

import commands.Command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

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

    public Optional<String> findCommandKey(String name) {
        if (Objects.nonNull(path)) {
            String[] folders = path.split(":");

            for (String folder : folders) {
                try (Stream<Path> files = Files.list(Paths.get(folder));) {
                    Optional<String> commandKey = files
                            .map(Path::getFileName)
                            .map(Path::toString)
                            .filter(file -> file.startsWith(name))
                            .findFirst();

                    if (commandKey.isPresent())
                        return commandKey;
                } catch (IOException ignored) {
                }
            }
        }

        return Optional.empty();
    }
}
