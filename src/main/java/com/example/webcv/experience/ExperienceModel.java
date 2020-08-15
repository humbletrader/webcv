package com.example.webcv.experience;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ExperienceModel {

    private String companyName;
    private String jobTitle;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate jobStart;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate jobEnd;

    public ExperienceModel(){

    }

    public ExperienceModel(String jobTitle,
                           String companyName,
                           LocalDate jobStartDate,
                           LocalDate jobEndDate) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.jobStart = jobStartDate;
        this.jobEnd = jobEndDate;
    }

    public ExperienceModel(Experience source){
        this.jobTitle = source.getJobTitle();
        this.companyName = source.getCompany().getName();
        this.jobStart = source.getStart();
        this.jobEnd = source.getEnd();
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

    public LocalDate getJobStart() {
        return jobStart;
    }

    public void setJobStart(LocalDate jobStartDate) {
        this.jobStart = jobStartDate;
    }

    public LocalDate getJobEnd() {
        return jobEnd;
    }

    public void setJobEndDate(LocalDate jobEndDate) {
        this.jobEnd = jobEndDate;
    }
}
