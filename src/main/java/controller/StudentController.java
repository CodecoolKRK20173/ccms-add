package controller;

import model.*;
import view.View;
import java.util.Arrays;
import java.util.List;

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
        view.printAssignmentList(studentAsssignmentList);
    }

    public void handleMenu(DataHandler dataHandler, String number) {
        
    }
}
