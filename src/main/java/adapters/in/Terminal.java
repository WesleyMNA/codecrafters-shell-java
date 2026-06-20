package adapters.in;

import domain.CommandResult;
import ports.in.Shell;

import java.util.Scanner;

public class Terminal {

    private final Shell shell;
    private final Scanner scanner;

    public Terminal(Shell shell) {
        this.shell = shell;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine();
            CommandResult result = shell.execute(input);

            if (result.exit())
                break;

            System.out.println(result.stdout());
        }
    }
}
