package com.resume.resumemakerapi.service;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;

import com.itextpdf.html2pdf.HtmlConverter;
import com.resume.resumemakerapi.helper.ResponseHelper;
import com.resume.resumemakerapi.helper.Template;
import com.resume.resumemakerapi.model.AllModel;

import org.springframework.stereotype.Service;

@Service
public class ResumeService {

    private StringBuilder getResumeData1(AllModel model){ 
        StringBuilder sb = new StringBuilder("");
        sb.append(Template.TOP);
        sb.append(Template.HEAD);
        sb.append(Template.BODY);
        sb.append("<table style='width:100%'><tr valign='top'><td class='pt-2' style='width:42%'><div class='text-center mb-2'>");
        sb.append("<img class='resume1-photo' src='"+model.getProfilePic()+"' alt='my photo'>");
        sb.append("</div><div class='line m-0 pr-2'></div><h4 class='mt-3 mb-2'>GET IN TOUCH!</h4>");
        if(model.getBasicDetails().getMobile()!=null && model.getBasicDetails().getMobile().trim()!="")
            sb.append("<label class='contact'><span class='color-custom-blue font-weigth-500'>Mobile:</span> <span><a class='link' href='tel:"+model.getBasicDetails().getMobile()+"'> "+model.getBasicDetails().getMobile()+"</a></span></label>");        
        if(model.getBasicDetails().getEmail()!=null && model.getBasicDetails().getEmail().trim()!="")
            sb.append("<label class='contact'><span class='color-custom-blue font-weigth-500'>Email:</span> <span><a class='link' href='mailto:"+model.getBasicDetails().getEmail()+"'> "+model.getBasicDetails().getEmail()+"</a></span></label>");
        model.getBasicDetails().getSocialLinks().forEach(a->{
            sb.append("<label class='contact'><span class='color-custom-blue font-weigth-500'>"+a.getAccount()+":</span> <span><a class='link' target='_blank' href='"+a.getLink()+"'> "+a.getLink()+"</a></span></label>");
        });
        sb.append("<div class='line mt-3 mb-3 pr-2'></div>");
        if(model.getPersonalInfo()!=null){
            sb.append("<label class='resume1-heading'>Personal details</label>");
            sb.append("<div class='font-size-12'>");
            if(model.getPersonalInfo().getCurrentLocation()!=null && model.getPersonalInfo().getCurrentLocation().trim()!="")
                sb.append("<table style='width:100%'><tr><td style='width:50%' class='font-weigth-500'>Current Location</td><td style='width:50%'>"+model.getPersonalInfo().getCurrentLocation()+"</td></tr></table>");
            if(model.getPersonalInfo().getHometown()!=null && model.getPersonalInfo().getHometown().trim()!="")
                sb.append("<table style='width:100%'><tr><td style='width:50%' class='font-weigth-500'>Home Town</td><td style='width:50%'>"+model.getPersonalInfo().getHometown()+"</td></tr></table>");
            if(model.getPersonalInfo().getDateOfBirth()!=null && model.getPersonalInfo().getDateOfBirth().getTime()!=0)
                sb.append("<table style='width:100%'><tr><td style='width:50%' class='font-weigth-500'>Date of birth</td><td style='width:50%'>"+new SimpleDateFormat("dd/MMM/yyyy").format(model.getPersonalInfo().getDateOfBirth())+"</td></tr></table>");
            if(model.getPersonalInfo().getGender()!=null && model.getPersonalInfo().getGender().trim()!="")
                sb.append("<table style='width:100%'><tr><td style='width:50%' class='font-weigth-500'>Gender</td><td style='width:50%'>"+model.getPersonalInfo().getGender()+"</td></tr></table>");
            if(model.getPersonalInfo().getMarried()!=null && model.getPersonalInfo().getMarried().trim()!="")
                sb.append("<table style='width:100%'><tr><td style='width:50%' class='font-weigth-500'>Married</td><td style='width:50%'>"+model.getPersonalInfo().getMarried()+"</td></tr></table>");
            if(model.getPersonalInfo().getLanguageKnown()!=null && model.getPersonalInfo().getLanguageKnown().trim()!="")
                sb.append("<table style='width:100%'><tr><td style='width:50%' class='font-weigth-500'>Language Known</td><td style='width:50%'>"+model.getPersonalInfo().getMarried()+"</td></tr></table>");
            if(model.getPersonalInfo().getLookingForA()!=null && model.getPersonalInfo().getLookingForA().trim()!="")
                sb.append(" <table style='width:100%'><tr><td style='width:50%' class='font-weigth-500'>Looking for a</td><td style='width:50%'>"+model.getPersonalInfo().getLookingForA()+"</td></tr></table>");
            if(model.getPersonalInfo().getCanStartWork()!=null && model.getPersonalInfo().getCanStartWork().trim()!="")
                sb.append("<table style='width:100%'><tr><td style='width:50%' class='font-weigth-500'>Can start working</td><td style='width:50%'>"+model.getPersonalInfo().getCanStartWork()+"</td></tr></table>");
            if(model.getPersonalInfo().getPreferedLocation()!=null && model.getPersonalInfo().getPreferedLocation().trim()!="")
                sb.append(" <table style='width:100%'><tr><td style='width:50%' class='font-weigth-500'>Preferred Location</td><td style='width:50%'>"+model.getPersonalInfo().getPreferedLocation()+"</td></tr></table>");    
            sb.append("</div>");
        }
        if(model.getStrengthsAndHobbies().getHobbies()!=null && model.getStrengthsAndHobbies().getHobbies().size()>0){
            sb.append("<div><label class='resume1-heading mt-3'>hobbies</label><ul>");
            model.getStrengthsAndHobbies().getHobbies().forEach(a->{
                sb.append("<li>"+a+"</li>");
            });
            sb.append("</ul></div>");
        }
        sb.append("</td><td class='mt-3' style='width:58%'>");
        sb.append("<div class='resume1-name'>"+model.getBasicDetails().getName()+"</div>");
        sb.append("<label class='resume1-heading'>career objective</label><p class='content'>"+model.getBasicDetails().getCareerObjective()+"</p>");
        
        if((model.getEducationSchools()!=null && model.getEducationSchools().size()>0) || (model.getEducationColleges()!=null && model.getEducationColleges().size()>0)){
            sb.append("<div><label class='resume1-education'>Education</label>");
            model.getEducationColleges().forEach(a->{
                sb.append("<div><label class='color-custom-blue resume1-education-heading'>"+a.getCourseName()+"</label><table class='content' style='width:100%'><tr><td style='width:25%'>College</td><td style='width:75%'>"+a.getCollegeName()+"</td></tr></table><table class='content' style='width:100%'><tr><td style='width:25%'>Passing Year</td><td style='width:75%'>"+a.getPassingYear()+"</td></tr></table><table class='content' style='width:100%'><tr><td style='width:25%'>Score</td><td style='width:75%'>"+a.getScore()+"</td></tr></table></div>");
            });
            model.getEducationSchools().forEach(a->{
                sb.append("<div><label class='color-custom-blue resume1-education-heading'>"+a.getName()+"</label><table class='content' style='width:100%'><tr><td style='width:25%'>School Name</td><td style='width:75%'>"+a.getSchoolName()+"</td></tr></table><table class='content' style='width:100%'><tr><td style='width:25%'>Board Name</td><td style='width:75%'>"+a.getBoard()+"</td></tr></table><table class='content' style='width:100%'><tr><td style='width:25%'>Passing Year</td><td style='width:75%'>"+a.getPassingYear()+"</td></tr></table><table class='content' style='width:100%'><tr><td style='width:25%'>Score</td><td style='width:75%'>"+a.getScore()+"</td></tr></table></div>");
            });
            sb.append("</div>");
        }
        if(model.getSkills()!=null && model.getSkills().size()>0){
            sb.append("<div><label class='resume1-heading mt-3'>Skills</label><ul>");
            model.getSkills().forEach(a->{
                sb.append("<li class='text-justify'><table style='width:100%'><tr><td style='width:42%' class='font-weigth-500'>"+a.getSkillName()+"</td><td style='width:58%'>"+a.getSkills()+"</td></tr></table></li>");
            });
            sb.append("</ul></div>");
        }
        if(model.getCertificates()!=null && model.getCertificates().size()>0){
            sb.append("<div><label class='resume1-heading mt-3'>Certifications</label><ul>");
            model.getCertificates().forEach(a->{
                sb.append("<li class='text-justify'>"+a.getCertificate()+"</li>");
            });
            sb.append("</ul></div>");
        }
        if(model.getExperiences()!=null && model.getExperiences().size()>0){
            sb.append("<div><label class='resume1-heading mt-3'>Expriences</label><ul>");
            model.getExperiences().forEach(a->{
                sb.append("<li><label class='text-bold project-content'>"+a.getCompanyName()+"</label><label class='project-content'><span class='font-weigth-500'>Job Profile:</span> "+a.getJobProfile()+"</label><label class='project-content'><span class='font-weigth-500'>Year of Experiences:</span> "+a.getYearOfExperience()+"</label></li>");
            });
            sb.append("</ul></div>");
        }
        if(model.getProjects()!=null && model.getProjects().size()>0) {
            sb.append("<div><label class='resume1-heading mt-3'>Projects</label><ul>");
            model.getProjects().forEach(a->{
                sb.append("<li><label class='text-bold project-content'>"+a.getName()+"</label><label class='project-content'><span class='font-weigth-500'>Associated with:</span> "+a.getAssociated()+"</label><label class='project-content'><span class='font-weigth-500'>Date:</span> "+a.getDate()+"</label><label class='project-content'><span class='font-weigth-500'>Description:</span> "+a.getDescription()+"</label></li>");
            });
            sb.append("</ul></div>");
        }
        if(model.getStrengthsAndHobbies().getStrengths()!=null && model.getStrengthsAndHobbies().getStrengths().size()>0){
            sb.append("<div><label class='resume1-heading mt-3'>Strengths</label><ul>");
            model.getStrengthsAndHobbies().getStrengths().forEach(a->{
                sb.append("<li>"+a+"</li>");
            });
            sb.append("</ul></div>");
        }
        sb.append("<label class='resume1-heading mt-3'>Declaration</label><p class='content'>"+model.getDeclaration()+"</p>");
        sb.append("</td></tr></table>");
        sb.append("<table class='mt-5 text-bold font-size-16' style='width:100%'><tr><td style='width:50%'>Date:</td><td class='text-right' style='width:50%'>Signature</td></tr></table>");
        sb.append(Template.FOOTER);
        return sb;
    }
    
    private StringBuilder getResumeData2(AllModel model){ 
        StringBuilder sb = new StringBuilder("");
        sb.append(Template.TOP);
        sb.append(Template.HEAD);
        sb.append(Template.BODY);
        sb.append("<div class='cover'><h1 class='name-tag'>"+model.getBasicDetails().getName()+"</h1><img class='photo' src='"+model.getProfilePic()+"' alt='my photo'></div>");
        sb.append("<div class='line'></div>");
        sb.append("<table style='width:100%'><tr valign='top'><td class='mt-5 pt-2'><div class='line m-0'></div><h4 class='mt-3 mb-2'>GET IN TOUCH</h4>");
        if(model.getBasicDetails().getMobile()!=null && model.getBasicDetails().getMobile().trim()!="")
            sb.append("<label class='contact'><span class='contact-link'>Mobile:</span> <span><a class='link' href='tel:"+model.getBasicDetails().getMobile()+"'> "+model.getBasicDetails().getMobile()+"</a></span></label>");
        if(model.getBasicDetails().getEmail()!=null && model.getBasicDetails().getEmail().trim()!="")
            sb.append("<label class='contact'><span class='contact-link'>Email:</span> <span><a class='link' href='mailto:"+model.getBasicDetails().getEmail()+"'> "+model.getBasicDetails().getEmail()+"</a></span></label>");
        model.getBasicDetails().getSocialLinks().forEach(a->{
            sb.append("<label class='contact'><span class='contact-link'>"+a.getAccount()+":</span> <span><a class='link' target='_blank' href='"+a.getLink()+"'> "+a.getLink()+"</a></span></label>");
        });
        sb.append("<div class='line mt-3 mb-3'>");
        if(model.getPersonalInfo()!=null){
            sb.append("</div><label class='heading'>Personal details</label>");
            sb.append("<ul>");
            if(model.getPersonalInfo().getCurrentLocation()!=null && model.getPersonalInfo().getCurrentLocation().trim()!="")
                sb.append("<li class='text-justify'><table style='width:100%'><tr><td style='width:50%' class='text-bold'>Current Location</td><td style='width:50%'>"+model.getPersonalInfo().getCurrentLocation()+"</td></tr></table></li>");
            if(model.getPersonalInfo().getHometown()!=null && model.getPersonalInfo().getHometown().trim()!="")
                sb.append("<li class='text-justify'><table style='width:100%'><tr><td style='width:50%' class='text-bold'>Home Town</td><td style='width:50%'>"+model.getPersonalInfo().getHometown()+"</td></tr></table></li>");
            if(model.getPersonalInfo().getDateOfBirth()!=null && model.getPersonalInfo().getDateOfBirth().getTime()!=0)
                sb.append("<li class='text-justify'><table style='width:100%'><tr><td style='width:50%' class='text-bold'>Date of birth</td><td style='width:50%'>"+new SimpleDateFormat("dd/MMM/yyyy").format(model.getPersonalInfo().getDateOfBirth())+"</td></tr></table></li>");
            if(model.getPersonalInfo().getGender()!=null && model.getPersonalInfo().getGender().trim()!="")
                sb.append("<li class='text-justify'><table style='width:100%'><tr><td style='width:50%' class='text-bold'>Gender</td><td style='width:50%'>"+model.getPersonalInfo().getGender()+"</td></tr></table></li>");
            if(model.getPersonalInfo().getMarried()!=null && model.getPersonalInfo().getMarried().trim()!="")
                sb.append("<li class='text-justify'><table style='width:100%'><tr><td style='width:50%' class='text-bold'>Married</td><td style='width:50%'>"+model.getPersonalInfo().getMarried()+"</td></tr></table></li>");
            if(model.getPersonalInfo().getLanguageKnown()!=null && model.getPersonalInfo().getLanguageKnown().trim()!="")
                sb.append("<li class='text-justify'><table style='width:100%'><tr><td style='width:50%' class='text-bold'>Language Known</td><td style='width:50%'>"+model.getPersonalInfo().getLanguageKnown()+"</td></tr></table></li>");
            if(model.getPersonalInfo().getLookingForA()!=null && model.getPersonalInfo().getLookingForA().trim()!="")
                sb.append("<li class='text-justify'><table style='width:100%'><tr><td style='width:50%' class='text-bold'>Looking for a</td><td style='width:50%'>"+model.getPersonalInfo().getLookingForA()+"</td></tr></table></li>");
            if(model.getPersonalInfo().getCanStartWork()!=null && model.getPersonalInfo().getCanStartWork().trim()!="")
                sb.append("<li class='text-justify'><table style='width:100%'><tr><td style='width:50%' class='text-bold'>Can start working</td><td style='width:50%'>"+model.getPersonalInfo().getCanStartWork()+"</td></tr></table></li>");
            if(model.getPersonalInfo().getPreferedLocation()!=null && model.getPersonalInfo().getPreferedLocation().trim()!="")
                sb.append("<li class='text-justify'><table style='width:100%'><tr><td style='width:50%' class='text-bold'>Preferred Location</td><td style='width:50%'>"+model.getPersonalInfo().getPreferedLocation()+"</td></tr></table></li>");
            sb.append("</ul>");
        }
        if(model.getStrengthsAndHobbies().getHobbies()!=null && model.getStrengthsAndHobbies().getHobbies().size()>0){
            sb.append("<div><label class='heading mt-3'>hobbies</label><ul>");
            model.getStrengthsAndHobbies().getHobbies().forEach(a->{
                sb.append("<li>"+a+"</li>");
            });
            sb.append("</ul></div>");
        }
        sb.append("</td>");
        sb.append("<td class='mt-3'><label class='heading'>career objective</label><p class='content'>"+model.getBasicDetails().getCareerObjective()+"</p>");
        if((model.getEducationSchools()!=null && model.getEducationSchools().size()>0) || (model.getEducationColleges()!=null && model.getEducationColleges().size()>0)){
            sb.append("<div><label class='education'>Education</label>");
            model.getEducationColleges().forEach(a->{
                sb.append("<div><label class='education-heading'>"+a.getCourseName()+"</label><table class='content' style='width:100%'><tr><td style='width:25%'>College</td><td style='width:75%'>"+a.getCollegeName()+"</td></tr></table><table class='content' style='width:100%'><tr><td style='width:25%'>Passing Year</td><td style='width:75%'>"+a.getPassingYear()+"</td></tr></table><table class='content' style='width:100%'><tr><td style='width:25%'>Score</td><td style='width:75%'>"+a.getScore()+"</td></tr></table></div>");
            });
            model.getEducationSchools().forEach(a->{
                sb.append("<div><label class='education-heading'>"+a.getName()+"</label><table class='content' style='width:100%'><tr><td style='width:25%'>School Name</td><td style='width:75%'>"+a.getSchoolName()+"</td></tr></table><table class='content' style='width:100%'><tr><td style='width:25%'>Board Name</td><td style='width:75%'>"+a.getBoard()+"</td></tr></table><table class='content' style='width:100%'><tr><td style='width:25%'>Passing Year</td><td style='width:75%'>"+a.getPassingYear()+"</td></tr></table><table class='content' style='width:100%'><tr><td style='width:25%'>Score</td><td style='width:75%'>"+a.getScore()+"</td></tr></table></div>");
            });
            sb.append("</div>");
        }
        if(model.getSkills()!=null && model.getSkills().size()>0){
            sb.append("<div><label class='heading mt-3'>Skills</label><ul>");
            model.getSkills().forEach(a->{
                sb.append("<li class='text-justify'><table style='width:100%'><tr><td style='width:42%' class='text-bold'>"+a.getSkillName()+"</td><td style='width:58%'>"+a.getSkills()+"</td></tr></table></li>");
            });
            sb.append("</ul></div>");
        }
        if(model.getCertificates()!=null && model.getCertificates().size()>0){
            sb.append("<div><label class='heading mt-3'>Certifications</label><ul>");
            model.getCertificates().forEach(a->{
                sb.append("<li class='text-justify'>"+a.getCertificate()+"</li>");
            });
            sb.append("</ul></div>");
        }
        if(model.getExperiences()!=null && model.getExperiences().size()>0){
            sb.append("<div><label class='heading mt-3'>Expriences</label><ul>");
            model.getExperiences().forEach(a->{
                sb.append("<li><label class='text-bold project-content'>"+a.getCompanyName()+"</label><label class='project-content'><span class='font-weigth-500'>Job Profile:</span> "+a.getJobProfile()+"</label><label class='project-content'><span class='font-weigth-500'>Year of Experiences:</span> "+a.getYearOfExperience()+"</label></li>");
            });
            sb.append("</ul></div>");
        }
        if(model.getProjects()!=null && model.getProjects().size()>0) {
            sb.append("<div><label class='heading mt-3'>Projects</label><ul>");
            model.getProjects().forEach(a->{
                sb.append("<li><label class='text-bold project-content'>"+a.getName()+"</label><label class='project-content'><span class='font-weigth-500'>Associated with:</span> "+a.getAssociated()+"</label><label class='project-content'><span class='font-weigth-500'>Date:</span> "+a.getDate()+"</label><label class='project-content'><span class='font-weigth-500'>Description:</span> "+a.getDescription()+"</label></li>");
            });
            sb.append("</ul></div>");
        }
        if(model.getStrengthsAndHobbies().getStrengths()!=null && model.getStrengthsAndHobbies().getStrengths().size()>0){
            sb.append("<div><label class='heading mt-3'>Strengths</label><ul>");
            model.getStrengthsAndHobbies().getStrengths().forEach(a->{
                sb.append("<li>"+a+"</li>");
            });
            sb.append("</ul></div>");
        }
        sb.append("<label class='heading mt-3'>Declaration</label><p class='content'>"+model.getDeclaration()+"</p>");
        sb.append("</td></tr></table>");
        sb.append("<table class='mt-5 text-bold font-size-16' style='width:100%'><tr><td style='width:50%'>Date:</td><td class='text-right' style='width:50%'>Signature</td></tr></table>");
        sb.append(Template.FOOTER);
        return sb;
    }
    
    private StringBuilder getResumeData3(AllModel model){ 
        StringBuilder sb = new StringBuilder("");
        sb.append(Template.TOP);
        sb.append(Template.HEAD);
        sb.append(Template.BODY);
        sb.append("<div class='resume3-cover'><h1 class='name-tag'>"+model.getBasicDetails().getName()+"</h1><img class='resume3-photo' [src]='imagePath' alt='my photo'></div>");
        sb.append("<table style='width:100%'><tr valign='top'><td class='mt-5 pt-2'><div class='line m-0'></div><h4 class='color-custom-green mt-3 mb-2'>GET IN TOUCH!</h4>");
        if(model.getBasicDetails().getMobile()!=null && model.getBasicDetails().getMobile().trim()!="")
            sb.append("<label class='contact'><span class='font-weigth-500'>Mobile:</span> <span><a class='link' href='tel:"+model.getBasicDetails().getMobile()+"'> "+model.getBasicDetails().getMobile()+"</a></span></label>");
        if(model.getBasicDetails().getEmail()!=null && model.getBasicDetails().getEmail().trim()!="")
            sb.append("<label class='contact'><span class='font-weigth-500'>Email:</span> <span><a class='link' href='mailto:"+model.getBasicDetails().getEmail()+"'> "+model.getBasicDetails().getEmail()+"</a></span></label>");
        model.getBasicDetails().getSocialLinks().forEach(a->{
            sb.append("<label class='contact'><span class='font-weigth-500'>"+a.getAccount()+":</span> <span><a class='link' target='_blank' href='"+a.getLink()+"'> "+a.getLink()+"</a></span></label>");
        });
        sb.append("<div class='line mt-3 mb-3'></div>");

        
        if(model.getPersonalInfo()!=null){
            sb.append("<label class='resume3-heading'>Personal details</label>");
            sb.append("<div class='font-size-12'>");
            if(model.getPersonalInfo().getCurrentLocation()!=null && model.getPersonalInfo().getCurrentLocation().trim()!="")
                sb.append("<table style='width:100%'><tr><td style='width:50%' class='font-weigth-500'>Current Location</td><td style='width:50%'>"+model.getPersonalInfo().getCurrentLocation()+"</td></tr></table>");
            if(model.getPersonalInfo().getHometown()!=null && model.getPersonalInfo().getHometown().trim()!="")
                sb.append("<table style='width:100%'><tr><td style='width:50%' class='font-weigth-500'>Home Town</td><td style='width:50%'>"+model.getPersonalInfo().getHometown()+"</td></tr></table>");
            if(model.getPersonalInfo().getDateOfBirth()!=null && model.getPersonalInfo().getDateOfBirth().getTime()!=0)
                sb.append("<table style='width:100%'><tr><td style='width:50%' class='font-weigth-500'>Date of birth</td><td style='width:50%'>"+new SimpleDateFormat("dd/MMM/yyyy").format(model.getPersonalInfo().getDateOfBirth())+"</td></tr></table>");
            if(model.getPersonalInfo().getGender()!=null && model.getPersonalInfo().getGender().trim()!="")
                sb.append("<table style='width:100%'><tr><td style='width:50%' class='font-weigth-500'>Gender</td><td style='width:50%'>"+model.getPersonalInfo().getGender()+"</td></tr></table>");
            if(model.getPersonalInfo().getMarried()!=null && model.getPersonalInfo().getMarried().trim()!="")
                sb.append("<table style='width:100%'><tr><td style='width:50%' class='font-weigth-500'>Married</td><td style='width:50%'>"+model.getPersonalInfo().getMarried()+"</td></tr></table>");
            if(model.getPersonalInfo().getLanguageKnown()!=null && model.getPersonalInfo().getLanguageKnown().trim()!="")
                sb.append("<table style='width:100%'><tr><td style='width:50%' class='font-weigth-500'>Language Known</td><td style='width:50%'>"+model.getPersonalInfo().getMarried()+"</td></tr></table>");
            if(model.getPersonalInfo().getLookingForA()!=null && model.getPersonalInfo().getLookingForA().trim()!="")
                sb.append(" <table style='width:100%'><tr><td style='width:50%' class='font-weigth-500'>Looking for a</td><td style='width:50%'>"+model.getPersonalInfo().getLookingForA()+"</td></tr></table>");
            if(model.getPersonalInfo().getCanStartWork()!=null && model.getPersonalInfo().getCanStartWork().trim()!="")
                sb.append("<table style='width:100%'><tr><td style='width:50%' class='font-weigth-500'>Can start working</td><td style='width:50%'>"+model.getPersonalInfo().getCanStartWork()+"</td></tr></table>");
            if(model.getPersonalInfo().getPreferedLocation()!=null && model.getPersonalInfo().getPreferedLocation().trim()!="")
                sb.append(" <table style='width:100%'><tr><td style='width:50%' class='font-weigth-500'>Preferred Location</td><td style='width:50%'>"+model.getPersonalInfo().getPreferedLocation()+"</td></tr></table>");    
            sb.append("</div>");
        }
        if(model.getStrengthsAndHobbies().getHobbies()!=null && model.getStrengthsAndHobbies().getHobbies().size()>0){
            sb.append("<div><label class='resume3-heading mt-3'>hobbies</label><ul>");
            model.getStrengthsAndHobbies().getHobbies().forEach(a->{
                sb.append("<li>"+a+"</li>");
            });
            sb.append("</ul></div>");
        }
        sb.append("</td>");
        sb.append("<td class='mt-3'><label class='resume3-heading'>career objective</label><p class='content'>"+model.getBasicDetails().getCareerObjective()+"</p>");
        if((model.getEducationSchools()!=null && model.getEducationSchools().size()>0) || (model.getEducationColleges()!=null && model.getEducationColleges().size()>0)){
            sb.append("<div><label class='resume3-education'>Education</label>");
            model.getEducationColleges().forEach(a->{
                sb.append("<div><label class='resume3-education-heading'>"+a.getCourseName()+"</label><table class='content' style='width:100%'><tr><td style='width:25%'>College</td><td style='width:75%'>"+a.getCollegeName()+"</td></tr></table><table class='content' style='width:100%'><tr><td style='width:25%'>Passing Year</td><td style='width:75%'>"+a.getPassingYear()+"</td></tr></table><table class='content' style='width:100%'><tr><td style='width:25%'>Score</td><td style='width:75%'>"+a.getScore()+"</td></tr></table></div>");
            });
            model.getEducationSchools().forEach(a->{
                sb.append("<div><label class='resume3-education-heading'>"+a.getName()+"</label><table class='content' style='width:100%'><tr><td style='width:25%'>School Name</td><td style='width:75%'>"+a.getSchoolName()+"</td></tr></table><table class='content' style='width:100%'><tr><td style='width:25%'>Board Name</td><td style='width:75%'>"+a.getBoard()+"</td></tr></table><table class='content' style='width:100%'><tr><td style='width:25%'>Passing Year</td><td style='width:75%'>"+a.getPassingYear()+"</td></tr></table><table class='content' style='width:100%'><tr><td style='width:25%'>Score</td><td style='width:75%'>"+a.getScore()+"</td></tr></table></div>");
            });
            sb.append("</div>");
        }
        if(model.getSkills()!=null && model.getSkills().size()>0){
            sb.append("<div><label class='resume3-heading mt-3'>Skills</label><ul>");
            model.getSkills().forEach(a->{
                sb.append("<li class='text-justify'><table style='width:100%'><tr><td style='width:42%' class='text-bold'>"+a.getSkillName()+"</td><td style='width:58%'>"+a.getSkills()+"</td></tr></table></li>");
            });
            sb.append("</ul></div>");
        }
        if(model.getCertificates()!=null && model.getCertificates().size()>0){
            sb.append("<div><label class='resume3-heading mt-3'>Certifications</label><ul>");
            model.getCertificates().forEach(a->{
                sb.append("<li class='text-justify'>"+a.getCertificate()+"</li>");
            });
            sb.append("</ul></div>");
        }
        if(model.getExperiences()!=null && model.getExperiences().size()>0){
            sb.append("<div><label class='resume3-heading mt-3'>Expriences</label><ul>");
            model.getExperiences().forEach(a->{
                sb.append("<li><label class='text-bold project-content'>"+a.getCompanyName()+"</label><label class='project-content'><span class='font-weigth-500'>Job Profile:</span> "+a.getJobProfile()+"</label><label class='project-content'><span class='font-weigth-500'>Year of Experiences:</span> "+a.getYearOfExperience()+"</label></li>");
            });
            sb.append("</ul></div>");
        }
        if(model.getProjects()!=null && model.getProjects().size()>0) {
            sb.append("<div><label class='resume3-heading mt-3'>Projects</label><ul>");
            model.getProjects().forEach(a->{
                sb.append("<li><label class='text-bold project-content'>"+a.getName()+"</label><label class='project-content'><span class='font-weigth-500'>Associated with:</span> "+a.getAssociated()+"</label><label class='project-content'><span class='font-weigth-500'>Date:</span> "+a.getDate()+"</label><label class='project-content'><span class='font-weigth-500'>Description:</span> "+a.getDescription()+"</label></li>");
            });
            sb.append("</ul></div>");
        }
        if(model.getStrengthsAndHobbies().getStrengths()!=null && model.getStrengthsAndHobbies().getStrengths().size()>0){
            sb.append("<div><label class='resume3-heading mt-3'>Strengths</label><ul>");
            model.getStrengthsAndHobbies().getStrengths().forEach(a->{
                sb.append("<li>"+a+"</li>");
            });
            sb.append("</ul></div>");
        }
        sb.append("<label class='resume3-heading mt-3'>Declaration</label><p class='content'>"+model.getDeclaration()+"</p>");
        sb.append("</td></tr></table>");
        sb.append("<table class='mt-5 text-bold font-size-16' style='width:100%'><tr><td style='width:50%'>Date:</td><td class='text-right' style='width:50%'>Signature</td></tr></table>");
        sb.append(Template.FOOTER);
        return sb;
    }
    
    public ResponseHelper resume1(AllModel model) {
        String sb = new String(this.getResumeData1(model));
        ByteArrayOutputStream os = new ByteArrayOutputStream();  
        HtmlConverter.convertToPdf(sb, os);
        byte[] content = os.toByteArray();
        ResponseHelper rh = new ResponseHelper();
        rh.setStatus(200);
        rh.setContent(content);
        return rh;
    }
    
    public ResponseHelper resume2(AllModel model) {
        String sb = new String(this.getResumeData2(model));
        ByteArrayOutputStream os = new ByteArrayOutputStream();  
        HtmlConverter.convertToPdf(sb, os);
        byte[] content = os.toByteArray();
        ResponseHelper rh = new ResponseHelper();
        rh.setStatus(200);
        rh.setContent(content);
        return rh;
    }

    public ResponseHelper resume3(AllModel model) {
        String sb = new String(this.getResumeData3(model));
        ByteArrayOutputStream os = new ByteArrayOutputStream();  
        HtmlConverter.convertToPdf(sb, os);
        byte[] content = os.toByteArray();
        ResponseHelper rh = new ResponseHelper();
        rh.setStatus(200);
        rh.setContent(content);
        return rh;
    }

}
