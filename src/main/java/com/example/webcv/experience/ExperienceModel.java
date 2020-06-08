package com.example.webcv.experience;

public class ExperienceModel {

    private Integer companyId;
    private String companyName;
    private String jobTitle;

    public ExperienceModel(){

    }

    public ExperienceModel(String jobTitle, Integer companyId, String companyName) {
        this.jobTitle = jobTitle;
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public ExperienceModel(Experience source){
        this.jobTitle = source.getJobTitle();
        this.companyId = source.getCompany().getId();
        this.companyName = source.getCompany().getName();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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
