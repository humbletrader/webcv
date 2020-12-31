package com.example.webcv.experience;


import java.util.Optional;

public interface UserExperienceService {

    Iterable<ExperienceModel> retrieveExperienceForUser(Integer userId);

    Optional<Integer> addExperience(Integer userId, ExperienceModel newExperience);

    Optional<Integer> updateExperience(Integer userId, ExperienceModel updatedExperience);

    Optional<Integer> deleteExperience(Integer userId, Integer experienceId);

}
