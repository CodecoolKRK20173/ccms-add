package model;

import java.util.ArrayList;
import java.util.List;

public class DataHandler {

    private List<User> studentList = new ArrayList<>(); 
    private List<User> mentorList = new ArrayList<>(); 
    private List<User> officeWorkerList = new ArrayList<>(); 
    private List<User> managerList = new ArrayList<>(); 
    private List<Assigment> assignmentList = new ArrayList<>(); 
    
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
    
    public List<Assigment> getAssignmentList() {
        return this.studentList;
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

    public void addAssignment(Assigment assigment) {
        assignmentList.add(assigment);
    }

    public void gradeAssignment(Student student, Assigment assigment, int grade) {

    }

    public void submitAssignment(Student student, Assigment assigment, String link) {

    }

    public void checkAttendence() {
        
    }
}
