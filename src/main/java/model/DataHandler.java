package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {

    private List<User> studentList = new ArrayList<>();
    private List<User> mentorList = new ArrayList<>(); 
    private List<User> officeWorkerList = new ArrayList<>(); 
    private List<User> managerList = new ArrayList<>(); 
    private List<Assignment> assignmentList = new ArrayList<>(); 
    
    public DataHandler(String filename) {

    }

    public List<User> getStudentList() {
        return this.studentList;
    }

    public List<User> getMentorList() {
        return this.studentList;
    }    
    
    public List<User> getOfficeWorkerList() {
        return this.studentList;
    }    
    
    public List<User> getManagerList() {
        return this.studentList;
    }    
    
    public List<Assignment> getAssignmentList() {
        return this.assignmentList;
    }

    private void readDataFromFile(String filename) {

    }

    public void saveDataToFile(String filename) {

    }


    public void addUser(User user) {
        if (user instanceof Student) {
            studentList.add(user);
        } else if (user instanceof Mentor) {
            studentList.add(user);
        } else if (user instanceof Manager) {
            studentList.add(user);
        } else if (user instanceof OfficeWorker) {
            studentList.add(user);
        }
    }

    public void removeUser(User user) {
        if (user instanceof Student) {
            studentList.remove(user);
        } else if (user instanceof Mentor) {
            studentList.remove(user);
        } else if (user instanceof Manager) {
            studentList.remove(user);
        } else if (user instanceof OfficeWorker) {
            studentList.remove(user);
        }
    }

    public void editUser(User user) {
        //
    }

    public void addAssignment(Assignment assigment) {
        assignmentList.add(assigment);
    }

    public boolean gradeAssignment(Student student, Assignment assigment, int grade) {
        for (StudentAssignment studentAssignment : student.getAssignmentList()) {
            if (studentAssignment.getAssignment().equals(assigment)) {
                studentAssignment.setGrade(grade);
                return true;
            }
        }
        return false;
    }

    public boolean submitAssignment(Student student, Assignment assigment, String link) {
        for (StudentAssignment studentAssignment : student.getAssignmentList()) {
            if (studentAssignment.getAssignment().equals(assigment)) {
                studentAssignment.setLink(link);
                return true;
            }
        }
        return false;
    }

    public void checkAttendence() {
        
    }
}
