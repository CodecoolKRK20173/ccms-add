package controller;

import model.User;
import view.View;
import java.util.List;

public class OfficeWorkerController extends UserController {


    public OfficeWorkerController(User loggedUser, View view) {
        super(loggedUser, view);
    }

    public void listStudents(List<User> studentsList) {
        view.printUserList(studentsList);
    }

    public void handleMenu() {

    }


}
