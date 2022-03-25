package com.resume.resumemakerapi.model;

public class EducationCollege {
    
    private String courseName;
    
    private String collegeName;

    private String passingYear;

    private String score;

    public EducationCollege(String courseName, String collegeName, String passingYear, String score) {
        this.courseName = courseName;
        this.collegeName = collegeName;
        this.passingYear = passingYear;
        this.score = score;
    }

    public EducationCollege() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(String passingYear) {
        this.passingYear = passingYear;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "EducationCollege [collegeName=" + collegeName + ", courseName=" + courseName + ", passingYear="
                + passingYear + ", score=" + score + "]";
    }

}
