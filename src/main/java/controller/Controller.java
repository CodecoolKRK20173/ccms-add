package controller;

import model.DataHandler;
import view.View;
import model.User;

import java.util.List;
import java.util.Scanner;

public class Controller {

    private DataHandler dataHandler;
    private View view;
    private UserController userController;


    public Controller(DataHandler dataHandler, View view, UserController userController) {
        this.dataHandler = dataHandler;
        this.view = view;
        this.userController = userController;
    }

    public User checkLogin(DataHandler dataHandler) {
        boolean loginIncorrect = true;
        User loggedUser = null;
        while (loginIncorrect) {
            System.out.println("Login:   ");
            Scanner input = view.getScanner();

                loggedUser = userIterator(dataHandler.getStudentList(), input);
            if (loggedUser == null)
                loggedUser = userIterator(dataHandler.getManagerList(), input);
            if (loggedUser == null)
                loggedUser = userIterator(dataHandler.getMentorList(), input);
            if (loggedUser == null)
                loggedUser = userIterator(dataHandler.getOfficeWorkerList(), input);
            if (loggedUser != null) {
                loginIncorrect = false;
            }
        }
        System.out.println("no such user");
        return checkPassword(loggedUser);
    }

    private User userIterator(List<User> userList, Scanner input) {
        for (User element : userList) {
            if (element.getLogin().equals(input)) {
                return element;
            }
        }
        return null;
    }

    public User checkPassword(User user) {
        boolean passwordIncorrect = true;
        while(passwordIncorrect) {
            System.out.println("Password:   ");
            Scanner inputPass = view.getScanner();
            if (user.getPassword().equals(inputPass)) {
               passwordIncorrect = false;
            }
            else {
                System.out.println("wrong pass");
            }
        }
        return user;
    }


}
