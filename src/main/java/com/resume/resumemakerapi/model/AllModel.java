package com.resume.resumemakerapi.model;

import java.util.List;

public class AllModel {
    
    private String profilePic;

    private BasicDetails basicDetails;

    private PersonalInfo personalInfo;

    private List<EducationSchool> educationSchools;

    private List<EducationCollege> educationColleges;

    private List<Skill> skills;

    private List<Certificate> certificates;

    private List<Experience> experiences;

    private StrengthsAndHobbies strengthsAndHobbies;

    private List<Project> projects;

    private String declaration;

   
    public AllModel(String profilePic, BasicDetails basicDetails, PersonalInfo personalInfo,
            List<EducationSchool> educationSchools, List<EducationCollege> educationColleges, List<Skill> skills,
            List<Certificate> certificates, List<Experience> experiences, StrengthsAndHobbies strengthsAndHobbies,
            List<Project> projects, String declaration) {
        this.profilePic = profilePic;
        this.basicDetails = basicDetails;
        this.personalInfo = personalInfo;
        this.educationSchools = educationSchools;
        this.educationColleges = educationColleges;
        this.skills = skills;
        this.certificates = certificates;
        this.experiences = experiences;
        this.strengthsAndHobbies = strengthsAndHobbies;
        this.projects = projects;
        this.declaration = declaration;
    }

    public AllModel() {
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public BasicDetails getBasicDetails() {
        return basicDetails;
    }

    public void setBasicDetails(BasicDetails basicDetails) {
        this.basicDetails = basicDetails;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public List<EducationSchool> getEducationSchools() {
        return educationSchools;
    }

    public void setEducationSchools(List<EducationSchool> educationSchools) {
        this.educationSchools = educationSchools;
    }

    public List<EducationCollege> getEducationColleges() {
        return educationColleges;
    }

    public void setEducationColleges(List<EducationCollege> educationColleges) {
        this.educationColleges = educationColleges;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public StrengthsAndHobbies getStrengthsAndHobbies() {
        return strengthsAndHobbies;
    }

    public void setStrengthsAndHobbies(StrengthsAndHobbies strengthsAndHobbies) {
        this.strengthsAndHobbies = strengthsAndHobbies;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    @Override
    public String toString() {
        return "AllModel [basicDetails=" + basicDetails + ", certificates=" + certificates + ", declaration="
                + declaration + ", educationColleges=" + educationColleges + ", educationSchools=" + educationSchools
                + ", experiences=" + experiences + ", personalInfo=" + personalInfo + ", profilePic=" + profilePic
                + ", projects=" + projects + ", skills=" + skills + ", strengthsAndHobbies=" + strengthsAndHobbies
                + "]";
    }

}
