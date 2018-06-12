package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    private List<StudentAssignment> assignmentList;

    public Student(String login, String password, String name, String surname) {
        super(login, password, name, surname);
        this.assignmentList = new ArrayList<StudentAssignment>();
    }

    public List<StudentAssignment> getAssignmentList() {
        return assignmentList;
    }
}
