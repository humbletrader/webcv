package com.example.webcv.experience;

import com.example.webcv.company.Company;
import com.example.webcv.user.User;

import javax.persistence.*;

@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String jobTitle;

    @ManyToOne
    private User user;

    @ManyToOne
    private Company company;

    public Experience() {
    }

    public Experience(Integer id, String jobTitle, Company company){
        this.id = id;
        this.jobTitle = jobTitle;
        this.company = company;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
