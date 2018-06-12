package model;

import java.util.ArrayList;
import java.util.List;

public class DataHandler {

    private List<User> studentList; 
    private List<User> mentorList; 
    private List<User> officeWorkerList;
    private List<User> managerList; 
    private List<Assignment> assignmentList;
    
    public DataHandler() {
        studentList = new ArrayList<>(); 
        mentorList = new ArrayList<>(); 
        officeWorkerList = new ArrayList<>(); 
        managerList = new ArrayList<>(); 
        assignmentList = new ArrayList<>(); 
    }

    public List<User> getStudentList() {
        return this.studentList;
    }

    public List<User> getMentorList() {
        return this.mentorList;
    }    
    
    public List<User> getOfficeWorkerList() {
        return this.officeWorkerList;
    }    
    
    public List<User> getManagerList() {
        return this.managerList;
    }    
    
    public List<Assignment> getAssignmentList() {
        return this.assignmentList;
    }

    public void addUser(User user) {
        if (user instanceof Student) {
            studentList.add(user);
        } else if (user instanceof Mentor) {
            mentorList.add(user);
        } else if (user instanceof Manager) {
            managerList.add(user);
        } else if (user instanceof OfficeWorker) {
            officeWorkerList.add(user);
        }
    }

    public void removeUser(User user) {
        if (user instanceof Student) {
            studentList.remove(user);
        } else if (user instanceof Mentor) {
            mentorList.remove(user);
        } else if (user instanceof Manager) {
            managerList.remove(user);
        } else if (user instanceof OfficeWorker) {
            officeWorkerList.remove(user);
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
