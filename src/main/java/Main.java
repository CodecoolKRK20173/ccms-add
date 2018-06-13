import controller.*;
import model.*;
import view.View;

import java.util.Scanner;

public class Main {

    private static FileHandler fileHandler;

    public static void main(String[] args) {

        String filename = "src/main/resources/usersData.txt";
        
        Controller mainController = new Controller(filename);
        mainController.execute();
    }
}