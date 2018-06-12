package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    private List<Assignment> assignmentList;

    public Student(String login, String password, String name, String surname) {
        super(login, password, name, surname);
        this.assignmentList = new ArrayList<Assignment>();
    }

    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }
}
