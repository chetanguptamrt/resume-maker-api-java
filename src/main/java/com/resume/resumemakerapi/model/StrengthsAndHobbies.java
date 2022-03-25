package com.resume.resumemakerapi.model;

import java.util.List;

public class StrengthsAndHobbies {
    
    private List<String> strengths;
    
    private List<String> hobbies;

    public StrengthsAndHobbies(List<String> strengths, List<String> hobbies) {
        this.strengths = strengths;
        this.hobbies = hobbies;
    }

    public StrengthsAndHobbies() {
    }

    public List<String> getStrengths() {
        return strengths;
    }

    public void setStrengths(List<String> strengths) {
        this.strengths = strengths;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "StrengthsAndHobbies [hobbies=" + hobbies + ", strengths=" + strengths + "]";
    }

}
