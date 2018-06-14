package controller;

import model.*;
import view.View;
import java.lang.Exception;
import java.util.Arrays;
import java.util.List;

public class OfficeWorkerController extends UserController {

    {
        menu = Arrays.asList("List students");
    }

    public OfficeWorkerController(User loggedUser, DataHandler dataHandler, View view) {
        super(loggedUser, dataHandler, view);
    }

    public void listStudents() throws Exception {
        view.printUserList(dataHandler.getStudentList());
    }

    public void handleMenu(Integer number) {
        switch (number) {
            // 1 "List students"
            case 1:
                try {  
                    listStudents();
                    break;
                } catch (Exception e) {
                    view.printMessage(e.getMessage());
                    break;                     
                }   
            default:
                break;
        }
    }
}
