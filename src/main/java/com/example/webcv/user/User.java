package com.example.webcv.user;


import com.example.webcv.experience.Experience;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String photoLink;

    @OneToMany(mappedBy = "user")
    private Set<Experience> experience = new HashSet<>();

    public User(){}

    public User(Integer id, String username){
        this(id, username, null);
    }

    public User(Integer id, String username, String photoLink) {
        this.id = id;
        this.username = username;
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

    public Set<Experience> getExperience() {
        return experience;
    }
    public void setExperience(Set<Experience> experience){
        this.experience = experience;
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
