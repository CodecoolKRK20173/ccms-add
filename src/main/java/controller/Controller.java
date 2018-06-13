package controller;

import model.DataHandler;
import view.View;
import model.User;

import java.util.List;
import java.util.Scanner;

public class Controller {

    private DataHandler dataHandler;
    private View view;


    public Controller() {
        this.dataHandler = new DataHandler();
        this.view = new View();
    }

    public User checkLogin(DataHandler dataHandler) {
        User loggedUser;
        while (true) {
            System.out.println("Login:   ");
            Scanner scanner = new Scanner(System.in);
            String login = scanner.nextLine();

                loggedUser = userIterator(dataHandler.getStudentList(), login);
            if (loggedUser == null)
                loggedUser = userIterator(dataHandler.getManagerList(), login);
            if (loggedUser == null)
                loggedUser = userIterator(dataHandler.getMentorList(), login);
            if (loggedUser == null)
                loggedUser = userIterator(dataHandler.getOfficeWorkerList(), login);
            if (loggedUser != null) {
                break;
            }
            System.out.println("no such user");
        }
        return checkPassword(loggedUser);
    }

    private User userIterator(List<User> userList, String input) {
        System.out.println("iterator" + "index: " + userList.size());
        for (User element : userList) {
            if (element.getLogin().equals(input)) {
                System.out.println("mam");
                return element;
            }
            else{
                System.out.println("npe");
            }
        }
        return null;
    }

    public User checkPassword(User user) {
        boolean passwordIncorrect = true;
        while(passwordIncorrect) {
            System.out.println("Password:   ");
            Scanner scanner = new Scanner(System.in);
            String password = scanner.nextLine();
            if (user.getPassword().equals(password)) {
               passwordIncorrect = false;
            }
            else {
                System.out.println("wrong pass");
            }
        }
        return user;
    }

    public DataHandler getDataHandler() {
        return dataHandler;
    }

    public View getView() {
        return view;
    }

    public void setDataHandler(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }
}
