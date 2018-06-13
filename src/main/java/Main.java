import controller.*;
import model.*;
import view.View;

import java.util.Scanner;

public class Main {

    private static FileHandler fileHandler;

    public static void main(String[] args) {
        View view = new View();
        Controller mainController = new Controller();
        DataHandler dataHandler = mainController.getDataHandler();
        fileHandler = new FileHandler(dataHandler);
        
        //test user - first usage of application
        if (dataHandler.getManagerList().size() == 0) {
            Manager manager = new Manager("test","test","test","test");
            dataHandler.addUser(manager);
        }
                
        //read from file
        fileHandler.readFromFile(mainController);
        mainController.getView().printUserList(fileHandler.getDataHandler().getManagerList());
        
        User loggedUser = mainController.checkLogin(mainController.getDataHandler());
        UserController userController = new ManagerController(loggedUser, view);
        
        Integer menuItem = -1;
        while (menuItem != 0) {
            view.printMenu(userController.getMenu());
            menuItem = view.getAnswerAsInt("Option: ");
            userController.handleMenu(mainController.getDataHandler(), menuItem);
        }
        fileHandler.saveToFile();
    }
}