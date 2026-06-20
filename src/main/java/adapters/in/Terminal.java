package adapters.in;

import java.util.Scanner;

public class Terminal {

    public void run() {
        System.out.print("$ ");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        System.out.printf("%s: command not found", command);
    }
}
