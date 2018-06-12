package controller;

import java.util.Arrays;
import java.util.List;
import model.StudentAssignment;
import model.User;
import view.View;

public class StudentController extends UserController {


    {
        menu = Arrays.asList("View my grades", "Submit assignment", "Exit CcMS");
    }


    public StudentController(User loggedUser, View view) {
        super(loggedUser, view);
    }


    public void submitAssignment() {

    }

    public void listAssignment(List<StudentAssignment> studentAsssignmentList) {
        view.printUserList(studentAsssignmentList);
    }


    public void handleMenu() {

    }

}
