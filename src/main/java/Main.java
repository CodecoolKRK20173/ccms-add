import controller.Controller;
import controller.FileHandler;
import controller.ManagerController;
import model.Manager;
import model.User;
import view.View;

import java.util.Scanner;

public class Main {

    private static FileHandler fileHandler;

    public static void main(String[] args) {
        Controller app = new Controller();
        fileHandler = new FileHandler(app.getDataHandler());
        //Manager manager = new Manager("q","w","dawid","grygier");
        //app.getDataHandler().getManagerList().add(manager);
        fileHandler.readFromFile(app);
        app.getView().printUserList(fileHandler.getDataHandler().getManagerList());
        User loggedUser = app.checkLogin(app.getDataHandler());
        ManagerController managerController = new ManagerController(loggedUser, new View());
        while(true){
            managerController.getView().printMenu(managerController.getMenu());
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if (choice.equals("0")){
                fileHandler.saveToFile();
                break;
            }
            managerController.handleMenu(app.getDataHandler(), choice);
        }
    }
}
