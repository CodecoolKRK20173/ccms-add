package controller;

import model.DataHandler;
import view.View;
import model.User;

public class Controller {

    private DataHandler dataHandler;
    private View view;
    private UserController userController;


    public Controller(DataHandler dataHandler, View view, UserController userController) {
        this.dataHandler = dataHandler;
        this.view = view;
        this.userController = userController;
    }

    public User checkLogin(String login) {


        return user;
    }

    public User checkPassword(User user, String password) {
        if(user.getPassword().equals(password)) {
            return user;
        }
    }


}
