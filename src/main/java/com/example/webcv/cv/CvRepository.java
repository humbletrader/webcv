package com.example.webcv.cv;

import com.example.webcv.user.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface CvRepository extends Repository<AppUser, Integer> {

    @Query(value = "select u from AppUser u join fetch u.experience e join fetch e.company c")
    AppUser findUserWithExperience(Integer userId);

}
