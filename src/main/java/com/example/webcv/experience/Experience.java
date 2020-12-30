package com.example.webcv.experience;

import com.example.webcv.company.Company;
import com.example.webcv.user.AppUser;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String jobTitle;

    @ManyToOne
    private AppUser appUser;

    @ManyToOne
    private Company company;

    private LocalDate jobStart;
    private LocalDate jobEnd;

    public Experience() {
    }

    public Experience(Integer id, String jobTitle, Company company, LocalDate jobStart, LocalDate jobEnd){
        this.id = id;
        this.jobTitle = jobTitle;
        this.company = company;
        this.jobStart = jobStart;
        this.jobEnd = jobEnd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String title) {
        this.jobTitle = title;
    }

    public AppUser getUser() {
        return appUser;
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDate getJobStart() {
        return jobStart;
    }

    public void setJobStart(LocalDate start) {
        this.jobStart = start;
    }

    public LocalDate getJobEnd() {
        return jobEnd;
    }

    public void setJobEnd(LocalDate end) {
        this.jobEnd = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Experience that = (Experience) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
