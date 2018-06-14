package controller;

import model.*;
import view.View;
import java.util.Arrays;
import java.util.List;

public class StudentController extends UserController {

    {
        menu = Arrays.asList("View assignments", 
                            "Submit assignment");
    }

    public StudentController(User loggedUser, DataHandler dataHandler, View view) {
        super(loggedUser, dataHandler, view);
    }

<<<<<<< HEAD
=======
    public void listStudentAssignments() {
        view.printStudentAssignmentList(((Student) loggedUser).getAssignmentList());
    }

>>>>>>> e46cac35ed5cf082e1ea2ad43681edd268e1c870
    public void submitAssignment() {
        listStudentAssignments();

        String assignmentId = view.getAnswerAsString("Type assignment's id: ");
        Assignment assignment = dataHandler.getAssignmentById(assignmentId);
        String link = view.getAnswerAsString("Type link: ");
            
        dataHandler.submitAssignment((Student) loggedUser, assignment, link);
    }

<<<<<<< HEAD
    public void listAssignment(List<StudentAssignment> studentAssignmentList) {
        view.printAssignmentList(studentAssignmentList);
    }

    public void handleMenu(DataHandler dataHandler, Integer number) {
        switch(number) {
            // 1 "View my grades"
            case 1:
                listAssignment();
            // 2 "Submit assignment"
            case 2:
               submitAssignment();
=======
    public void handleMenu(Integer number) {

        switch (number) {
            // 1 "View assignments"
            case 1:
                listStudentAssignments();
                break;
            // 2 "Submit assignment"
            case 2:
                submitAssignment();
                break;
            
            default:
                break;
>>>>>>> e46cac35ed5cf082e1ea2ad43681edd268e1c870
        }
    }
}
