package com.resume.resumemakerapi.model;

public class EducationSchool {
    
    private String name;
    
    private String schoolName;

    private String board;

    private String passingYear;

    private String score;

    public EducationSchool(String name, String schoolName, String board, String passingYear, String score) {
        this.name = name;
        this.schoolName = schoolName;
        this.board = board;
        this.passingYear = passingYear;
        this.score = score;
    }

    public EducationSchool() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
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
        return "EducationSchool [board=" + board + ", name=" + name + ", passingYear=" + passingYear + ", schoolName="
                + schoolName + ", score=" + score + "]";
    }

}
