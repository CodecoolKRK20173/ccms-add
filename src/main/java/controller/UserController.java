package controller;

import model.User;
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

    public abstract void handleMenu();

}
