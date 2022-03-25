package com.resume.resumemakerapi.model;

public class Skill {
    
    private String skillName;

    private String skills;

    public Skill(String skillName, String skills) {
        this.skillName = skillName;
        this.skills = skills;
    }

    public Skill() {
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Skill [skillName=" + skillName + ", skills=" + skills + "]";
    }

}
