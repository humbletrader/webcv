package com.example.webcv.cv;

import com.example.webcv.experience.Experience;
import com.example.webcv.experience.ExperienceModel;

import java.util.Set;

public class CvModel {

    private final String firstName;
    private final String lastName;
    private final String photo;

    private final Set<ExperienceModel> experiences;

    public CvModel(String firstName, String lastName, String photo, Set<ExperienceModel> experiences){
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
        this.experiences = experiences;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoto() {
        return photo;
    }

    public Set<ExperienceModel> getExperiences() {
        return experiences;
    }
}
