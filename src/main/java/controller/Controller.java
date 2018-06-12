package controller;

import model.DataHandler;
import view.View;
import model.User;

public class Controller {

    private DataHandler dataHandler;
    private View view;
    private UserController userController;


    public Controller(DataHandler dataHandler, View view, UserController userController) {
        this.dataHandler = new DataHandler();
        this.view = new View();
    }

    public User checkLogin(String login) {

    }

    public User checkPassword(String password) {

    }


}
