package controller;

import model.*;
import java.util.Arrays;
import java.util.List;
import view.View;

public class ManagerController extends UserController {

    {
        menu = Arrays.asList("List mentors", 
                            "List students",
                            "Add mentor",
                            "Remove mentor",
                            "Edit mentor");
    }

    public ManagerController(User loggedUser, DataHandler dataHandler, View view) {
        super(loggedUser, dataHandler, view);
    }

    public void addMentor() {
        String login = view.getAnswerAsString("Type mentor's login: ");
        String password = view.getAnswerAsString("Type mentor's password: ");
        String name = view.getAnswerAsString("Type mentor's name: ");
        String surname = view.getAnswerAsString("Type mentor's surname: ");
        
        dataHandler.addUser(new Mentor(login, password, name, surname));
        view.printMessage("Mentor added.");        
    }

    public void removeMentor() {
        listMentors();        
        view.printMessage("Who remove?");        
        dataHandler.removeUser(chooseMentor());
        view.printMessage("Mentor removed.");
    }

    public void editMentor() {
        listMentors();
        view.printMessage("Who edit?");        
        User mentor = chooseMentor();
        
        String password = view.getAnswerAsString("Type new mentor's password (or nothing): ");
        String name = view.getAnswerAsString("Type new mentor's name (or nothing): ");
        String surname = view.getAnswerAsString("Type new mentor's surname (or nothing): ");
        
        dataHandler.editUser(mentor, password, name, surname);
        view.printMessage("Mentor edited.");
    }

    private User chooseMentor() {
        String login;
        User mentor = null;

        while (mentor == null) {
            login = view.getAnswerAsString("Type mentor's login: ");
            mentor = dataHandler.getMentorByLogin(login);
        }
        return mentor;
    }

    public void listStudents() {
        view.printUserList(dataHandler.getStudentList());
    }

    public void listMentors() {
        view.printUserList(dataHandler.getMentorList());
    }

    public void handleMenu(Integer number) {

        switch (number) {
            // 1 "List mentors"           
            case 1:
                listMentors();
                break;
            // 2 "List students"
            case 2:
                listStudents();
                break;
            // 3 "Add mentor"
            case 3:
                addMentor();
                break;
            // 4 "Remove mentor"
            case 4:
                removeMentor();
                break;
            // 5 "Edit mentor"
            case 5:
                editMentor();
                break;
            
            default:
                break;
        }    
    }
}
