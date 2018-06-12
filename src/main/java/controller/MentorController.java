package controller;

import model.User;
import java.util.List;
import model.Student;
import model.DataHandler;
import view.View;

public class MentorController extends UserController {


    public MentorController(User loggedUser, View view) {
        super(loggedUser, view);
    }


    public void addStudent(DataHandler dataHandler, Student student) {
        dataHandler.addUser(student);
    }

    public void removeStudent(DataHandler dataHandler, Student student) {
        dataHandler.removeUser(student);
    }

    public void editStudent() {

    }

    public void listStudents(List<Student> studentList) {
        super.view.printUserList(studentList);
    }

    public void addAssignment() {

    }

    public void gradeAssignment() {

    }

    public void checkAttendence() {

    }


    public void handleMenu() {

    }

}
