package views;

public class ShellView implements Observer {

    public void displayPrompt() {
        System.out.print("$ ");
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
