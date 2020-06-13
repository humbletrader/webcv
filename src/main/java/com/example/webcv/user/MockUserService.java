package com.example.webcv.user;

import com.example.webcv.experience.ExperienceModel;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Profile("mock")
@Service
public class MockUserService implements UserService{

    @Override
    public Iterable<UserModel> retrieveAllUsers() {
        return null;
    }

    @Override
    public Optional<UserModel> retrieveUser(Integer userId) {
        return Optional.empty();
    }

    @Override
    public Integer newUser(UserModel userModel) {
        return null;
    }

    @Override
    public Integer updateUser(UserModel userModel) throws UserDoesNotExistException {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public Optional<Integer> addExperience(Integer userId, ExperienceModel newExperience) {
        return Optional.empty();
    }
}
