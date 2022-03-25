package com.resume.resumemakerapi.model;

public class Experience {
    
    private String companyName;

    private String jobProfile;

    private String yearOfExperience;

    public Experience(String companyName, String jobProfile, String yearOfExperience) {
        this.companyName = companyName;
        this.jobProfile = jobProfile;
        this.yearOfExperience = yearOfExperience;
    }

    public Experience() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobProfile() {
        return jobProfile;
    }

    public void setJobProfile(String jobProfile) {
        this.jobProfile = jobProfile;
    }

    public String getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(String yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    @Override
    public String toString() {
        return "Experience [companyName=" + companyName + ", jobProfile=" + jobProfile + ", yearOfExperience="
                + yearOfExperience + "]";
    }

    

}
