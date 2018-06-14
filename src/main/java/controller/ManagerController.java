package controller;

import model.*;
import view.View;
import java.lang.Exception;
import java.util.Arrays;


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
        boolean uniquelogin = false;
        String login = "";
        while (!uniquelogin) {
            login =  view.getAnswerAsString("Type mentor\'s login: ");
            uniquelogin = this.dataHandler.isLoginUnique(this.dataHandler.getMentorList(), login);
            if (!uniquelogin){
                this.view.printMessage("login taken, try again");
            }
        }
        String password = view.getAnswerAsString("Type mentor's password: ");
        String name = view.getAnswerAsString("Type mentor's name: ");
        String surname = view.getAnswerAsString("Type mentor's surname: ");
        
        dataHandler.addUser(new Mentor(login, password, name, surname));
        view.printMessage("Mentor added.");        
    }

    public void removeMentor() {
        //if mentors list is not epmty remove
        try {  
            listMentors();        
            view.printMessage("Who remove?");        
            dataHandler.removeUser(chooseMentor());
            view.printMessage("Mentor removed.");
        } catch (Exception e) {
            view.printMessage(e.getMessage());                    
        }
    }

    public void editMentor() {
        //if mentors list is not epmty edit
        try {  
            listMentors();
            view.printMessage("Who edit?");        
            User mentor = chooseMentor();
            
            String password = view.getAnswerAsString("Type new mentor's password (or nothing): ");
            String name = view.getAnswerAsString("Type new mentor's name (or nothing): ");
            String surname = view.getAnswerAsString("Type new mentor's surname (or nothing): ");
            
            dataHandler.editUser(mentor, password, name, surname);
            view.printMessage("Mentor edited.");
        } catch (Exception e) {
            view.printMessage(e.getMessage());                    
        }
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

    public void listStudents() throws Exception {
        view.printUserList(dataHandler.getStudentList());
    }

    public void listMentors() throws Exception {
        view.printUserList(dataHandler.getMentorList());
    }

    public void handleMenu(Integer number) {

        switch (number) {
            // 1 "List mentors"           
            case 1:
                try {
                    listMentors();
                    break;
                } catch (Exception e) {
                    view.printMessage(e.getMessage());
                    break;                    
                }
            // 2 "List students"
            case 2:
                try {
                    listStudents();
                    break;
                } catch (Exception e) {
                    view.printMessage(e.getMessage());
                    break;                       
                }
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
