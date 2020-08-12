package com.example.webcv.experience;

public class ExperienceModel {

    private String companyName;
    private String jobTitle;

    public ExperienceModel(){

    }

    public ExperienceModel(String jobTitle, String companyName) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
    }

    public ExperienceModel(Experience source){
        this.jobTitle = source.getJobTitle();
        this.companyName = source.getCompany().getName();
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle){
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
