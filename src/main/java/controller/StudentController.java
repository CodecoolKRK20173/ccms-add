package controller;

import java.util.List;
import model.StudentAssignment;
import model.User;

public class StudentController extends UserController {


    public StudentController(User loggedUser) {
        super(loggedUser);
    }

    public void submitAssignment() {

    }

    public List<StudentAssignment> listAssignment() {
        return listAssignment;
    }

}
