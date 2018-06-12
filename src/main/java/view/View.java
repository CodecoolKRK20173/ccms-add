package view;

import model.User;

import java.util.List;
import java.util.Scanner;

public class View {

    public void printUserList(List<User> list){
        for (User element : list){
            printNameSurname(element);
        }
    }

    public void pressEnterKeyToContinue() {
        System.out.println("Press Enter key to continue...");
        Scanner pressEnter = new Scanner(System.in);
        String input = pressEnter.nextLine();
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void printNameSurname(User user){
        System.out.println("Name:  " + user.getName() + ",  Surname:  " + user.getSurname());
    }

}
