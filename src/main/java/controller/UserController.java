package controller;

import model.*;
import view.View;
import java.util.List;

public abstract class UserController {

    protected List<String> menu;
    protected User loggedUser;
    protected DataHandler dataHandler;
    protected View view;

    public UserController(User loggedUser, DataHandler dataHandler, View view) {
        this.loggedUser = loggedUser;
        this.view = view;
        this.dataHandler = dataHandler;
    }

    public List<String> getMenu() {
        return menu;
    }

    public View getView() {
        return view;
    }

    public abstract void handleMenu(Integer number);
    
}
