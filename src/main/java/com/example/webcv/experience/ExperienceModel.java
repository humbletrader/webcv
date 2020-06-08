package com.example.webcv.experience;

public class ExperienceModel {

    private String title;

    private String companyName;

    public ExperienceModel(){

    }

    public ExperienceModel(String title, String companyName) {
        this.title = title;
        this.companyName = companyName;
    }

    public ExperienceModel(Experience source){
        this.title = source.getTitle();
        this.companyName = source.getCompany().getName();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
