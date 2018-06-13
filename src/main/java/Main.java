import controller.Controller;
import model.Manager;
import model.User;

public class Main {



    public static void main(String[] args) {
        Controller app = new Controller();
        Manager manager = new Manager("q","w","dawid","grygier");
        app.getDataHandler().getManagerList().add(manager);
        User loggedUser = app.checkLogin(app.getDataHandler());
    }
}
