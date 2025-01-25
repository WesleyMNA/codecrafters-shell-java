import commands.CommandFactory;
import shell.Shell;

public class Main {

    public static void main(String[] args) {
        var factory = new CommandFactory();
        new Shell(factory).startRepl();
    }
}
