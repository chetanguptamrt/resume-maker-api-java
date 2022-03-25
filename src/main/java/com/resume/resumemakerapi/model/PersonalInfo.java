package com.resume.resumemakerapi.model;

import java.util.Date;

public class PersonalInfo {
    
    private String currentLocation;

    private String hometown;
    
    private Date dateOfBirth;
    
    private String gender;
    
    private String married;
    
    private String languageKnown;
    
    private String lookingForA;
    
    private String canStartWork;
    
    private String preferedLocation;

    public PersonalInfo(String currentLocation, String hometown, Date dateOfBirth, String gender, String married,
            String languageKnown, String lookingForA, String canStartWork, String preferedLocation) {
        this.currentLocation = currentLocation;
        this.hometown = hometown;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.married = married;
        this.languageKnown = languageKnown;
        this.lookingForA = lookingForA;
        this.canStartWork = canStartWork;
        this.preferedLocation = preferedLocation;
    }

    public PersonalInfo() {
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public String getLanguageKnown() {
        return languageKnown;
    }

    public void setLanguageKnown(String languageKnown) {
        this.languageKnown = languageKnown;
    }

    public String getLookingForA() {
        return lookingForA;
    }

    public void setLookingForA(String lookingForA) {
        this.lookingForA = lookingForA;
    }

    public String getCanStartWork() {
        return canStartWork;
    }

    public void setCanStartWork(String canStartWork) {
        this.canStartWork = canStartWork;
    }

    public String getPreferedLocation() {
        return preferedLocation;
    }

    public void setPreferedLocation(String preferedLocation) {
        this.preferedLocation = preferedLocation;
    }

    @Override
    public String toString() {
        return "PersonalInfo [canStartWork=" + canStartWork + ", currentLocation=" + currentLocation + ", dateOfBirth="
                + dateOfBirth + ", gender=" + gender + ", hometown=" + hometown + ", languageKnown=" + languageKnown
                + ", lookingForA=" + lookingForA + ", married=" + married + ", preferedLocation=" + preferedLocation
                + "]";
    }

}
