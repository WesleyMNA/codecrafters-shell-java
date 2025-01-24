import commands.CommandFactory;
import shell.Shell;

public class Main {

    public static void main(String[] args) {
        var factory = CommandFactory.getInstance();
        new Shell(factory).startRepl();
    }
}
