package domain;

public record CommandResult(
        String stdout,
        boolean exit
) {
}
