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

    public ManagerController(User loggedUser, View view) {
        super(loggedUser, view);
    }

    public void addMentor(DataHandler dataHandler) {
        String login = view.getAnswerAsString("Type mentor's login: ");
        String password = view.getAnswerAsString("Type mentor's password: ");
        String name = view.getAnswerAsString("Type mentor's name: ");
        String surname = view.getAnswerAsString("Type mentor's surname: ");
        
        dataHandler.addUser(new Mentor(login, password, name, surname));
    }

    public void removeMentor(DataHandler dataHandler) {
        view.printUserList(dataHandler.getMentorList());        
        view.printMessage("Who remove?");        
        dataHandler.removeUser(chooseMentor(dataHandler));
        view.printMessage("Mentor removed.");
    }

    private User chooseMentor(DataHandler dataHandler) {
        String login;
        User mentor = null;

        while (mentor == null) {
            login = view.getAnswerAsString("Type mentor's login: ");
            mentor = dataHandler.getMentorByLogin(login);
        }
        return mentor;
    }

    public void editMentor(DataHandler dataHandler) {
        User mentor;
        view.printUserList(dataHandler.getMentorList());        
        view.printMessage("Who edit?");        
        mentor = chooseMentor(dataHandler);
        
        String password = view.getAnswerAsString("Type new mentor's password (or nothing): ");
        String name = view.getAnswerAsString("Type new mentor's name (or nothing): ");
        String surname = view.getAnswerAsString("Type new mentor's surname (or nothing): ");
        
        dataHandler.editUser(mentor, password, name, surname);
        view.printMessage("Mentor edited.");
    }

    public void listStudents(DataHandler dataHandler) {
        view.printUserList(dataHandler.getStudentList());
    }

    public void listMentors(DataHandler dataHandler) {
        view.printUserList(dataHandler.getMentorList());
    }

    public void handleMenu(DataHandler dataHandler, String number) {

        switch (number) {
            // 1 "List mentors"           
            case "1":
                listMentors(dataHandler);
                break;
            // 2 "List students"
            case "2":
                listStudents(dataHandler);
                break;
            // 3 "Add mentor"
            case "3":
                addMentor(dataHandler);
                break;
            // 4 "Remove mentor"
            case "4":
                removeMentor(dataHandler);
                break;
            // 5 "Edit mentor"
            case "5":
                editMentor(dataHandler);
                break;
            
            default:
                break;
        }    
    }
}
