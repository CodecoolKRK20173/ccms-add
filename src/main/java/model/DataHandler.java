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

    public addUser(User user) {
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

    public removeUser(User user) {
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

    public editUser(User user) {
        //
    }

    public addAssignment(Assigment assigment) {
        assignmentList.add(assigment);
    }

    public gradeAssignment(Student student, Assigment assigment, int grade) {

    }

    public submitAssignment(Student student, Assigment assigment, String link) {

    }

    public checkAttendence() {
        
    }
}
