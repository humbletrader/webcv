package com.example.webcv.user;


import com.example.webcv.experience.Experience;
import com.example.webcv.experience.ExperienceModel;

import java.util.HashSet;
import java.util.Set;

public class UserModel {

    private final Integer id;
    private final String username;
    private final Set<ExperienceModel> experiences;

    public UserModel(Integer id, String username, Set<ExperienceModel> experiences) {
        this.id = id;
        this.username = username;
        this.experiences = experiences;
    }

    public UserModel(User source){
        this.id = source.getId();
        this.username = source.getUsername();
        this.experiences = new HashSet<>();
        for (Experience exp : source.getExperience()) {
            this.experiences.add(new ExperienceModel(exp));
        }
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Set<ExperienceModel> getExperiences(){
        return experiences;
    }
}
