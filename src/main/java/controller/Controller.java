package controller;

import model.DataHandler;
import view.View;

public class Controller {

    private DataHandler dataHandler;
    private View view;
    private UserController userController;


    public Controller(DataHandler dataHandler, View view) {
        this.dataHandler = new DataHandler();
        this.view = new View();
    }


}
