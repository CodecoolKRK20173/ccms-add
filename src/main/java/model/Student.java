package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends User {

    private List<StudentAssignment> assignmentList;
    private Map<String, String> studentAttendanceMap;

    public Student(String login, String password, String name, String surname) {
        super(login, password, name, surname);
        this.assignmentList = new ArrayList<StudentAssignment>();
        this.studentAttendanceMap = new HashMap<>();
    }

    public List<StudentAssignment> getAssignmentList() {
        return assignmentList;
    }

    public Map<String, String> getStudentAttendanceMap() {
        return studentAttendanceMap;
    }
}
