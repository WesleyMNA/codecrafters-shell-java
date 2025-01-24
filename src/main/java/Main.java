import controllers.ShellController;
import views.ShellView;

public class Main {

    public static void main(String[] args) {
        ShellView view = new ShellView();
        ShellController controller = new ShellController(view);
        controller.startRepl();
    }
}
