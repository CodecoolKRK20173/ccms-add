package controller;

import model.User;
import java.util.List;
import model.DataHandler;
import model.Mentor;
import model.Student;
import view.View;

public class ManagerController extends UserController {


    public ManagerController(User loggedUser, View view) {
        super(loggedUser, view);
    }

    public void addMentor(DataHandler dataHandler, Mentor mentor) {
        dataHandler.addUser(mentor);
    }

    public void removeMentor(DataHandler dataHandler, Mentor mentor) {
        dataHandler.removeUser(mentor);
    }

    public void editMentor() {

    }

    public void listStudents(List<User> studentList) {
        view.printUserList(studentList);
    }

    public void listMentors(List<User> mentorList) {
        view.printUserList(mentorList);
    }

    public void handleMenu() {

    }
}
