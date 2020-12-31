package com.example.webcv.experience;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserExperienceRepository extends CrudRepository<Experience, Integer> {

    @Query("from Experience e where e.appUser.id = :userId")
    Iterable<Experience> findExperiencesByUser(Integer userId);

}
