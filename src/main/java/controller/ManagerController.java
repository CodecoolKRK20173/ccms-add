package controller;

import model.User;
import java.util.List;
import model.DataHandler;
import model.Mentor;

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

    public List<User> listStudents() {

    }

    public List<User> listMentors() {

    }
}
