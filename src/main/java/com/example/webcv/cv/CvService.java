package com.example.webcv.cv;

import com.example.webcv.certification.CertificationModel;
import com.example.webcv.experience.Experience;
import com.example.webcv.experience.ExperienceModel;
import com.example.webcv.experience.UserExperienceRepository;
import com.example.webcv.user.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CvService {

    private final CvRepository cvRepository;

    public CvService(CvRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    public CvModel retrieveCv(Integer userId) throws UserDoesNotExistException{
        AppUser user = cvRepository.findUserWithExperience(userId);
        Set<ExperienceModel> certifications = user.getExperience().stream()
                .map(ExperienceModel::new)
                .collect(Collectors.toSet());

        return new CvModel(user.getFirstName(), user.getLastName(), user.getPhotoLink(), certifications);
    }

}
