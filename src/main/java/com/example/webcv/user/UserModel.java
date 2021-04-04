package com.example.webcv.user;


import com.example.webcv.experience.Experience;
import com.example.webcv.experience.ExperienceModel;

import java.util.HashSet;
import java.util.Set;

public class UserModel {

    private final int id;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String photoLink;
    private final int version;

    public UserModel(int id,
                     String username,
                     String firstName,
                     String lastName,
                     String photoLink,
                     int version) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photoLink = photoLink;
        this.version = version;
    }

    public UserModel(AppUser source){
        this.id = source.getId();
        this.username = source.getUsername();
        this.firstName = source.getFirstName();
        this.lastName = source.getLastName();
        this.photoLink = source.getPhotoLink();
        this.version = source.getVersion();
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public int getVersion(){
        return version;
    }

}
