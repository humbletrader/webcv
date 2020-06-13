package com.example.webcv.user;

import com.example.webcv.experience.ExperienceModel;

import java.util.Optional;

public interface UserService {

    Iterable<UserModel> retrieveAllUsers();

    Optional<UserModel> retrieveUser(Integer userId);

    Integer newUser(UserModel userModel);

    Integer updateUser(UserModel userModel) throws UserDoesNotExistException;

    void deleteUser(Integer userId);

    Optional<Integer> addExperience(Integer userId, ExperienceModel newExperience);
}
