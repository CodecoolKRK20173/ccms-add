package controller;

import model.DataHandler;
import view.View;
import model.User;

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
        System.out.println("Login:   ");
        Scanner input = view.getScanner();
        for (User element : dataHandler.getManagerList()) {
            if (element.getLogin().equals(input)) {
                return checkPassword(element);
            }
        }
        for (User element : dataHandler.getMentorList()) {
            if (element.getLogin().equals(input)) {
                return checkPassword(element);
            }
        }
        for (User element : dataHandler.getOfficeWorkerList()) {
            if (element.getLogin().equals(input)) {
                return checkPassword(element);
            }
        }
        for (User element : dataHandler.getStudentList()) {
            if (element.getLogin().equals(input)) {
                return checkPassword(element);
            }
        }
        System.out.println("no such user");
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
