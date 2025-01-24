package controllers;

import views.ShellView;

import java.util.Scanner;

public class ShellController {

    private final ShellView view;

    public ShellController(ShellView view) {
        this.view = view;
    }

    public void startRepl() {
        var scanner = new Scanner(System.in);

        while (true) {
            view.displayPrompt();
            String input = scanner.nextLine().trim();

            if (input.isEmpty())
                continue;

            if (input.startsWith("exit"))
                System.exit(0);
            else
                view.print(input + ": command not found");
        }
    }
}
