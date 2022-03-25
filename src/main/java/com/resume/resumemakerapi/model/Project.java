package com.resume.resumemakerapi.model;

public class Project {
    
    private String name;

    private String date;

    private String associated;

    private String description;

    public Project(String name, String date, String associated, String description) {
        this.name = name;
        this.date = date;
        this.associated = associated;
        this.description = description;
    }

    public Project() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAssociated() {
        return associated;
    }

    public void setAssociated(String associated) {
        this.associated = associated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project [associated=" + associated + ", date=" + date + ", description=" + description + ", name="
                + name + "]";
    }

}
