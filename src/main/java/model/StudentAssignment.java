package model;

import java.io.Serializable;

public class StudentAssignment implements Serializable {

    private Assignment assignment;
    private String link;
    private int grade;

    public StudentAssignment (Assignment assignment){
        this.assignment = assignment;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public int getGrade() {
        return grade;
    }

    public String getLink() {
        return link;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String toString() {
        return String.format("%s, link: %s, grade: %d",
                            assignment.toString(), link, grade);
    }
}
