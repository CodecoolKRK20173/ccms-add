package controller;

import java.util.List;

public abstract class UserController {

    private List<String> menu;
    private User loggedUser;


    public UserController(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public List<String> getMenu() {
        return menu;
    }

    public void handleMenu() {
        
    }

}
