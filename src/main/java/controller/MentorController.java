package controller;

import model.User;
import java.util.List;
import model.Student;
import model.DataHandler;

public class MentorController extends UserController {


    public MentorController(User loggedUser) {
        super(loggedUser);
    }


    public void addStudent(DataHandler dataHandler, Student student) {
        dataHandler.addUser(student);
    }

    public void removeStudent(DataHandler dataHandler, Student student) {
        dataHandler.removeUser(student);
    }

    public void editStudent() {

    }

    public List<User> listStudents() {

    }

    public void addAssignment() {

    }

    public void gradeAssignment() {

    }

    public void checkAttendence() {

    }

}
