package view;

import model.User;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

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

    public String getAnswerAsString(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    public Integer getAnswerAsInt(String question) {
        System.out.print(question);
        Integer input = null;
        while (input == null ) {
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("InputMismatchException");
            }
        }
        return input;
    }

    public void printMenu(List<String> menu) {
        System.out.printf("%nWhat would you like to do:%n");
        int index = 1;
        for (String menuItem : menu) {
            System.out.printf("    (%d) %s%n", index, menuItem);
            index++;
        }
        System.out.println("    (0) Exit");        
    }
}
