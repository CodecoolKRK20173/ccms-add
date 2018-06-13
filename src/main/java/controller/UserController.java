package controller;

import model.*;
import view.View;
import java.util.List;

public abstract class UserController {

    protected List<String> menu;
    private User loggedUser;
    protected View view;

    public UserController(User loggedUser, View view) {
        this.loggedUser = loggedUser;
        this.view = view;
    }

    public List<String> getMenu() {
        return menu;
    }

    public View getView() {
        return view;
    }

    public abstract void handleMenu(DataHandler dataHandler, String number);

}
