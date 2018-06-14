package controller;

import model.*;
import view.View;
import java.lang.Exception;
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

    public void listStudentAssignments() throws Exception {
        view.printStudentAssignmentList(((Student) loggedUser).getAssignmentList());
    }

    public void submitAssignment() {
        //if student's assignments list is not epmty submit
        try {  
            listStudentAssignments();

            String assignmentId = view.getAnswerAsString("Type assignment's id: ");
            Assignment assignment = dataHandler.getAssignmentById(assignmentId);
            String link = view.getAnswerAsString("Type link: ");
                
            dataHandler.submitAssignment((Student) loggedUser, assignment, link);
        } catch (Exception e) {
            view.printMessage(e.getMessage());                    
        }
    }

    public void handleMenu(Integer number) {

        switch (number) {
            // 1 "View assignments"
            case 1:
                try {  
                    listStudentAssignments();
                    break;
                } catch (Exception e) {
                    view.printMessage(e.getMessage());  
                    break;                  
                }
            // 2 "Submit assignment"
            case 2:
                submitAssignment();
                break;
            
            default:
                break;
        }
    }
}
