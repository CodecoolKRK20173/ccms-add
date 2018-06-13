package view;

import model.Assignment;
import model.StudentAssignment;
import model.User;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public String getAnswerAsString(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    public Integer getAnswerAsInt(String question) {
        Integer input = null;
        while (input == null) {
            System.out.print(question);            
            try {
                input = scanner.nextInt(); 
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.err.println("Type integer!");
            }
        }
        scanner.nextLine();
        return input;
    }

    public void printMessage(String message) {
        System.out.println(message);
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

    public void printUserList(List<User> list) {
        if (!isEmptyList(list)) {
            for (User user : list) {
                System.out.println(user.toString());
            }
        } 
    }

    public void printStudentAssignmentList(List<StudentAssignment> list) {
        if (!isEmptyList(list)) {
            for (StudentAssignment item : list) {
                System.out.println(item.toString());
            }
        } 
    }

    public void printAssigmentList(List<Assignment> list) {
        if (!isEmptyList(list)) {
            for (Assignment item : list) {
                System.out.println(item.toString());
            }
        }
    }

    private boolean isEmptyList(List list) {
        if (list.isEmpty()) {
            System.out.println("List is empty.");
            return true;
        }
        return false;
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /*
     * public void pressEnterKeyToContinue() {
     * System.out.println("Press Enter key to continue..."); Scanner pressEnter =
     * new Scanner(System.in); String input = pressEnter.nextLine(); }
     * 
     * public void printNameSurname(User user){ System.out.println("Name:  " +
     * user.getName() + ",  Surname:  " + user.getSurname() + "  login:  " +
     * user.getLogin() + "  password:  " + user.getPassword()); }
     */
}
