package adapters.in;

import java.util.Scanner;

public class Terminal {

    private final Scanner scanner;

    public Terminal() {
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.print("$ ");
            String command = scanner.nextLine();
            System.out.printf("%s: command not found%n", command);
        }
    }
}
