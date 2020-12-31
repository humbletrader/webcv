package com.example.webcv.experience;

import com.example.webcv.company.Company;
import com.example.webcv.company.CompanyRepository;
import com.example.webcv.user.AppUser;
import com.example.webcv.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserExperienceServiceImpl implements UserExperienceService{

    private static final Logger logger = LoggerFactory.getLogger(UserExperienceServiceImpl.class);

    private final UserRepository userRepository;
    private final UserExperienceRepository userExperienceRepository;
    private final CompanyRepository companyRepository;

    public UserExperienceServiceImpl(UserRepository userRepository,
                                     UserExperienceRepository userExperienceRepository,
                                     CompanyRepository companyRepository){
        this.userRepository = userRepository;
        this.userExperienceRepository = userExperienceRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public Iterable<ExperienceModel> retrieveExperienceForUser(Integer userId) {
        Iterator<Experience> experiences = userExperienceRepository.findExperiencesByUser(userId).iterator();
        List<ExperienceModel> result = new ArrayList<>();
        for (; experiences.hasNext(); ) {
            result.add(new ExperienceModel(experiences.next()));
        }

        return result;
    }

    @Override
    public Optional<Integer> addExperience(Integer userId, ExperienceModel newExperience) {

        Optional<AppUser> optionalUser = userRepository.findById(userId);
        return optionalUser.map(user -> {
            Company company = companyRepository
                    .findByName(newExperience.getCompanyName())
                    .orElseGet(() -> {
                        logger.info("company {} not found. Creating new company ..", newExperience.getCompanyName());
                        Company newComp = new Company();
                        newComp.setName(newExperience.getCompanyName());
                        return companyRepository.save(newComp);
                    });

            Experience exp = new Experience();
            exp.setUser(user);
            exp.setJobTitle(newExperience.getJobTitle());
            exp.setCompany(company);
            exp.setJobStart(newExperience.getJobStart());
            exp.setJobEnd(newExperience.getJobEnd());

            return userExperienceRepository.save(exp).getId();
        });
    }

    @Override
    public Optional<Integer> updateExperience(Integer userId, ExperienceModel updatedExperience) {
        logger.info("searching for user {} and experience {}", userId, updatedExperience.getExpId());
        return userRepository.findById(userId).flatMap(user -> {
            logger.info("found user {} ", user.getId());
            //todo: we should replace this with a single findByUserAndExpId instead of performing two queries
            return userExperienceRepository
                    .findById(updatedExperience.getExpId())
                    .map(experience -> {
                        logger.info("found experience {}", experience.getId());
                        experience.setJobTitle(updatedExperience.getJobTitle());
                        //todo: handle change of company
                        experience.setJobStart(updatedExperience.getJobStart());
                        experience.setJobEnd(updatedExperience.getJobEnd());
                        return userExperienceRepository.save(experience).getId();
                    });
        });
    }

    @Override
    public Optional<Integer> deleteExperience(Integer userId, Integer experienceId) {
        return userRepository
                .findById(userId)
                .flatMap(user -> {
                    //todo: delete in one single statement (where userid = ? and expId =? )
                    userExperienceRepository.deleteById(experienceId);
                    return Optional.empty();
                });
    }
}
