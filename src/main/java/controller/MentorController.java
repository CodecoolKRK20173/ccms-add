package controller;

import model.*;
import view.View;
import java.lang.Exception;
import java.util.Arrays;

public class MentorController extends UserController {

    {
        menu = Arrays.asList("List students",
                            "Add student",
                            "Remove student",
                            "Edit student",
                            "List assignments",
                            "Add assignment",
                            "Add assignment to student",
                            "Grade student's assignment",
                            "Check attendance");
    }
        
    public MentorController(User loggedUser, DataHandler dataHandler, View view) {
        super(loggedUser, dataHandler, view);
    }

    public void addStudent() {

        boolean uniquelogin = false;
        String login = "";
        while (!uniquelogin) {
            login =  view.getAnswerAsString("Type student\'s login: ");
            uniquelogin = this.dataHandler.isLoginUnique(this.dataHandler.getStudentList(), login);
            if (!uniquelogin){
                System.out.println("login taken, try again");
            }
        }
        String password = view.getAnswerAsString("Type student\'s password: ");
        String name = view.getAnswerAsString("Type student\'s name: ");
        String surname = view.getAnswerAsString("Type student\'s surname: ");

        dataHandler.addUser(new Student(login, password, name, surname));
        view.printMessage("Student added.");
    }

    public void removeStudent() {
        //if students list is not epmty remove
        try {  
            listStudents();
            view.printMessage("Who remove?");        
            dataHandler.removeUser(chooseStudent());
            view.printMessage("Student removed.");
        } catch (Exception e) {
            view.printMessage(e.getMessage());                    
        }
    }

    public void editStudent() {
        //if students list is not epmty edit
        try {  
            listStudents();
            view.printMessage("Who edit?");        
            User student = chooseStudent();
            
            String password = view.getAnswerAsString("Type new student's password (or nothing): ");
            String name = view.getAnswerAsString("Type new student's name (or nothing): ");
            String surname = view.getAnswerAsString("Type new student's surname (or nothing): ");
            
            dataHandler.editUser(student, password, name, surname);
            view.printMessage("Student edited.");
        } catch (Exception e) {
            view.printMessage(e.getMessage());                    
        }
    }

    private Student chooseStudent() {
        String login;
        User student = null;

        while (student == null) {
            login = view.getAnswerAsString("Type student's login: ");
            student = dataHandler.getStudentByLogin(login);
        }
        return (Student) student;
    }

    public void listStudents() throws Exception {
        view.printUserList(dataHandler.getStudentList());
    }

    public void listAssignments() throws Exception {
        view.printAssigmentList(dataHandler.getAssignmentList());
    }

    public void addAssignment() {
        boolean uniqueId = false;
        String assignmentId = "";
        while (!uniqueId) {
            assignmentId =  view.getAnswerAsString("Type assignment name: ");
            uniqueId = this.dataHandler.isIdUnique(this.dataHandler.getAssignmentList(), assignmentId);
            if (!uniqueId){
                System.out.println("Name taken, try again");
            }
        }
        String description = view.getAnswerAsString("Type description: ");
        dataHandler.addAssignment(new Assignment(assignmentId, description));
    }

    public void addAssignmentToStudent() {
        //if students list is not epmty add
        try {  
            listStudents();
            view.printMessage("Choose student: ");        
            Student student = chooseStudent();

            listAssignments();
            String assignmentId = view.getAnswerAsString("Type assignment's id: ");
            Assignment assignment = dataHandler.getAssignmentById(assignmentId);

            student.addAssignment(assignment);
        } catch (Exception e) {
            view.printMessage(e.getMessage());                    
        }
    }

    public void gradeAssignment() {
        //if students list is not epmty grade
        try {  
            listStudents();
            view.printMessage("Choose student: ");        
            Student student = chooseStudent();

            listAssignments();
            String assignmentId = view.getAnswerAsString("Type assignment's id: ");
            Assignment assignment = dataHandler.getAssignmentById(assignmentId);

            int grade = view.getAnswerAsInt("Type grade: ");
            dataHandler.gradeAssignment(student, assignment, grade);
        } catch (Exception e) {
            view.printMessage(e.getMessage());                    
        }
    }

    public void checkAttendance() {

    }

    public void handleMenu(Integer number) {

        switch (number) {
            // 1 "List students"
            case 1:
                try {  
                    listStudents();
                    break;
                } catch (Exception e) {
                    view.printMessage(e.getMessage());  
                    break;                  
                }                
            // 2 "Add student"
            case 2:
                addStudent();
                break;
            // 3 "Remove student"
            case 3:
                removeStudent();
                break;
            // 4 "Edit student"
            case 4:
                editStudent();
                break;
            // 5 "List assignments"
            case 5:
                try {  
                    listAssignments();
                    break;
                } catch (Exception e) {
                    view.printMessage(e.getMessage());  
                    break;                  
                }  
            // 6 "Add assignment"
            case 6:
                addAssignment();
                break;
            // 7 "Add assignment to student"
            case 7:
                addAssignmentToStudent();
                break;
            // 8 "Grade student's assignment"
            case 8:
                gradeAssignment();
                break;
            // 9 "Check attendance"
            case 9:
                checkAttendance();
                break;
            default:
                break;
        }
    }
}
