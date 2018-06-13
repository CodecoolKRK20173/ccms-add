package controller;

import model.Assignment;
import model.User;
import java.util.List;
import model.Student;
import model.DataHandler;
import view.View;
import java.util.List;

public class MentorController extends UserController {

    public MentorController(User loggedUser, View view) {
        super(loggedUser, view);
    }


    public void addStudent(DataHandler dataHandler) {

        String login = view.getAnswerAsString("Type student\'s login: ");
        String password = view.getAnswerAsString("Type student\'s password: ");
        String name = view.getAnswerAsString("Type student\'s name: ");
        String surname = view.getAnswerAsString("Type student\'s surname: ");

        dataHandler.addUser(new Student(login, password, name, surname));
    }

    public void removeStudent(DataHandler dataHandler) {
        listStudents(dataHandler.getStudentList());
        String login = view.getAnswerAsString("Which student do you want to remove?: ");

        dataHandler.removeUser(dataHandler.getStudentByLogin(login));
    }

    public void editStudent(DataHandler dataHandler) {
        listStudents(dataHandler.getStudentList());
        String login = view.getAnswerAsString("Which student do you want to edit?: ");

        //dataHandler.editUser(dataHandler.getStudentByLogin(login));
    }

    public void listStudents(List<User> studentList) {
        view.printUserList(studentList);
    }

    public void listAssignments(List<Assignment> assignmentList) {
        view.printGeneralAssigmentList(assignmentList);
    }

    public void addAssignment(DataHandler dataHandler) {
        String description = view.getAnswerAsString("Type description of assignment: ");
        String assignmentId = Integer.toString(getLastIndexOfAssignment(dataHandler));
        dataHandler.addAssignment(new Assignment(assignmentId, description));
    }

    public int getLastIndexOfAssignment(DataHandler datahandler) {
        int lastIndexOfAssignment = datahandler.getAssignmentList().size();
        return lastIndexOfAssignment;
    }

    public void addAssignmentToStudent(DataHandler dataHandler) {

    }

    public void gradeAssignment(DataHandler dataHandler) {
        listStudents(dataHandler.getStudentList());
        String login = view.getAnswerAsString("Which student do you want to grade assignment?: ");
        
        listAssignments(dataHandler.getAssignmentList());
        String assignmentId = view.getAnswerAsString("Which assignment do you want to grade?: ");
        Assignment assignment = dataHandler.getAssignmentById(assignmentId);

        int grade = view.getAnswerAsInt("Type grade: ");

        dataHandler.gradeAssignment(dataHandler.getStudentByLogin(login), assignment, grade);
    }

    public void checkAttendence() {

    }

    public void handleMenu(DataHandler dataHandler, String number) {
        
    }
}
