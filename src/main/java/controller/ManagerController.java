package controller;

import model.User;
import java.util.List;
import model.DataHandler;
import model.Mentor;
import model.Student;
import view.View;

public class ManagerController extends UserController {


    public ManagerController(User loggedUser) {
        super(loggedUser);
    }

    public void addMentor(DataHandler dataHandler, Mentor mentor) {
        dataHandler.addUser(mentor);
    }

    public void removeMentor(DataHandler dataHandler, Mentor mentor) {
        dataHandler.removeUser(mentor);
    }

    public void editMentor() {

    }

    public List<User> listStudents(View view, List<Student> studentList) {
        view.printUserList(studentList);
    }

    public List<User> listMentors(View view, List<Mentor> mentorList) {
        view.printUserList(mentorList);
    }
}
