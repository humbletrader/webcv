package com.example.webcv.user;


import com.example.webcv.certification.Certification;
import com.example.webcv.experience.Experience;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String firstName;
    private String lastName;
    private String photoLink;

    @OneToMany(mappedBy = "user")
    private Set<Experience> experience = new HashSet<>();

    @ManyToMany
    private Set<Certification> certifications = new HashSet<>();

    public User(){}

    public User(Integer id, String username, String firstName, String lastName, String photoLink) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photoLink = photoLink;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPhotoLink() {
        return photoLink;
    }
    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getFirstName() { return firstName;}
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Experience> getExperience() {
        return experience;
    }
    public void setExperience(Set<Experience> experience){
        this.experience = experience;
    }

    public Set<Certification> getCertifications(){ return certifications; }
    public void setCertifications(Set<Certification> certifications){
        this.certifications = certifications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", experience=" + experience +
                '}';
    }
}
