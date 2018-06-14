package controller;

import model.*;
import view.View;
import model.User;

import java.lang.Exception;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private String filename;
    private DataHandler dataHandler;
    private View view;

    public Controller(String filename) {
        this.filename = filename;
        this.view = new View();
        this.dataHandler = FileHandler.readFromFile(this.filename, this.view);

        if (dataHandler == null) {
            dataHandler = initTestData();
        }
    }

    private DataHandler initTestData() {
        DataHandler dataHandler = new DataHandler();
        Manager manager = new Manager("test","test","test","test");
        dataHandler.addUser(manager);
        return dataHandler;
    }

    public void execute() {
        User loggedUser;
        UserController userController;
        Integer mainMenuItem = -1, userMenuItem;

        //main menu in loop
        while (mainMenuItem != 0) {
            view.printMenu(Arrays.asList("Login"));
            mainMenuItem = view.getAnswerAsInt("Type option: ");
            if (mainMenuItem == 1) {
                try {       
                    userMenuItem = -1;
                    //for tests
                    view.printMessage("Manager login: test, password: test");
                    loggedUser = login();
                    //view.printMessage("Logged as " + loggedUser.getName());                    

                    userController = initUserController(loggedUser);
                    //user menu in loop
                    while (userMenuItem != 0) {
                        view.printMenu(userController.getMenu());
                        userMenuItem = view.getAnswerAsInt("Type option: ");
                        userController.handleMenu(userMenuItem);
                    }
                    FileHandler.saveToFile(dataHandler, filename, view);
                } catch (Exception e) {
                    view.printMessage(e.getMessage());
                }
            }
        }
    }

    private User login() throws Exception {
        User user;
        user = checkLogin();
        if (user == null) {
            throw new Exception("Bad login."); 
        } else {
            if (checkPassword(user) != true) {
                throw new Exception("Wrong password.");
            }
        }
        return user;
    }

    private User checkLogin() {
        String login = view.getAnswerAsString("Type user login: ");
        return dataHandler.getUserByLogin(login);
    }

    private boolean checkPassword(User user) {
        String password = view.getAnswerAsString("Type user password: ");
        return user.getPassword().equals(password) ? true : false;
    }

    private UserController initUserController(User user) {
        UserController userController = null;
        if (user instanceof Student) {
            userController = new StudentController(user, this.dataHandler, this.view);
        } else if (user instanceof Mentor) {
            userController = new MentorController(user, this.dataHandler, this.view);
        } else if (user instanceof Manager) {
            userController = new ManagerController(user, this.dataHandler, this.view);
        } else if (user instanceof OfficeWorker) {
            userController = new OfficeWorkerController(user, this.dataHandler, this.view);
        }
        return userController;

    }

    public DataHandler getDataHandler() {
        return dataHandler;
    }

    public View getView() {
        return view;
    }
}
