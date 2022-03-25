package com.resume.resumemakerapi.model;

import java.util.List;

public class BasicDetails {
    
    private String name;

    private String mobile;

    private String email;

    private String careerObjective;

    private List<SocialLink> socialLinks;

    public BasicDetails(String name, String mobile, String email, String careerObjective,
            List<SocialLink> socialLinks) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.careerObjective = careerObjective;
        this.socialLinks = socialLinks;
    }

    public BasicDetails() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCareerObjective() {
        return careerObjective;
    }

    public void setCareerObjective(String careerObjective) {
        this.careerObjective = careerObjective;
    }

    public List<SocialLink> getSocialLinks() {
        return socialLinks;
    }

    public void setSocialLinks(List<SocialLink> socialLinks) {
        this.socialLinks = socialLinks;
    }

    @Override
    public String toString() {
        return "BasicDetails [careerObjective=" + careerObjective + ", email=" + email + ", mobile=" + mobile
                + ", name=" + name + ", socialLinks=" + socialLinks + "]";
    }

}
