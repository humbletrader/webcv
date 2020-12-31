package com.example.webcv.experience;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary //stupid
public class MockUserExperienceService implements UserExperienceService{

    @Override
    public Iterable<ExperienceModel> retrieveExperienceForUser(Integer userId) {
        return null;
    }

    @Override
    public Optional<Integer> addExperience(Integer userId, ExperienceModel newExperience) {
        return Optional.empty();
    }

    @Override
    public Optional<Integer> updateExperience(Integer userId, ExperienceModel updatedExperience) {
        return Optional.empty();
    }

    @Override
    public Optional<Integer> deleteExperience(Integer userId, Integer experienceId) {
        return Optional.empty();
    }
}
