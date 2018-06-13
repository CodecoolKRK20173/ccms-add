package controller;

import model.*;
import view.View;

import java.util.Arrays;
import java.util.List;

public class OfficeWorkerController extends UserController {

    {
        menu = Arrays.asList("List students");
    }

    public OfficeWorkerController(User loggedUser, View view) {
        super(loggedUser, view);
    }

    public void listStudents(List<User> studentsList) {
        view.printUserList(studentsList);
    }

    public void handleMenu(DataHandler dataHandler, Integer number) {
        switch (number) {
            // 1 "List students"
            case "1":
                listStudents(dataHandler.getStudentList());
            default:
                break;
        }
    }
}
