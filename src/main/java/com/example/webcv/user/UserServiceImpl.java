package com.example.webcv.user;


import com.example.webcv.certification.Certification;
import com.example.webcv.certification.CertificationModel;
import com.example.webcv.certification.CertificationRepository;
import com.example.webcv.company.Company;
import com.example.webcv.company.CompanyRepository;
import com.example.webcv.experience.Experience;
import com.example.webcv.experience.ExperienceModel;
import com.example.webcv.experience.ExperienceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final CompanyRepository companyRepository;

    private final UserRepository userRepository;

    private final ExperienceRepository experienceRepository;

    private final CertificationRepository certificationRepository;

    //autowiring of parameters done by default by spring (since 4.x or something)
    public UserServiceImpl(CompanyRepository companyRepository,
                           ExperienceRepository experienceRepository,
                           CertificationRepository certificationRepository,
                           UserRepository userRepository) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
        this.experienceRepository = experienceRepository;
        this.certificationRepository = certificationRepository;
    }

    @Override
    public Iterable<UserModel> retrieveAllUsers() {
        List<UserModel> result = new ArrayList<>();
        Iterator<AppUser> users = userRepository.findAll().iterator();
        for (; users.hasNext(); ) {
            result.add(new UserModel(users.next()));
        }
        return result;
    }

    @Override
    public Optional<UserModel> retrieveUser(Integer userId) {
        return userRepository.findById(userId).map(UserModel::new);
    }

    @Override
    public Integer newUser(UserModel userModel) {
        AppUser newAppUser = new AppUser();
        newAppUser.setUsername(userModel.getUsername());
        newAppUser.setFirstName(userModel.getFirstName());
        newAppUser.setLastName(userModel.getLastName());
        newAppUser.setPhotoLink(userModel.getPhotoLink());
        return userRepository.save(newAppUser).getId();
    }

    @Override
    public Integer updateUser(UserModel userModel) throws UserDoesNotExistException {
        boolean userExists = userRepository.existsById(userModel.getId());
        if (userExists) {
            AppUser modifiedAppUser = new AppUser(userModel.getId(),
                    userModel.getUsername(),
                    userModel.getFirstName(),
                    userModel.getLastName(),
                    userModel.getPhotoLink()
            );
            return userRepository.save(modifiedAppUser).getId();
        } else {
            throw new UserDoesNotExistException();
        }
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
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
            exp.setStart(newExperience.getJobStart());
            exp.setEnd(newExperience.getJobEnd());

            return experienceRepository.save(exp).getId();
        });
    }

    @Override
    public Optional<Integer> updateExperience(Integer userId, ExperienceModel updatedExperience) {
        logger.info("searching for user {} and experience {}", userId, updatedExperience.getExpId());
        return userRepository.findById(userId).flatMap(user -> {
            logger.info("found user {} ", user.getId());
            //todo: we should replace this with a single findByUserAndExpId instead of performing two queries
            return experienceRepository
                    .findById(updatedExperience.getExpId())
                    .map(experience -> {
                        logger.info("found experience {}", experience.getId());
                        experience.setJobTitle(updatedExperience.getJobTitle());
                        //todo: handle change of company
                        experience.setStart(updatedExperience.getJobStart());
                        experience.setEnd(updatedExperience.getJobEnd());
                        return experienceRepository.save(experience).getId();
                    });
        });
    }

    @Override
    public Optional<Integer> deleteExperience(Integer userId, Integer experienceId) {
        return userRepository
                .findById(userId)
                .flatMap(user -> {
                    //todo: delete in one single statement (where userid = ? and expId =? )
                    experienceRepository.deleteById(experienceId);
                    return Optional.empty();
                });
    }

    @Override
    public Optional<Integer> addCertification(Integer userId, CertificationModel certifModel) {
        return userRepository.findById(userId).map(user -> {

            //todo: check if the certification already exists
            Certification newCertification = new Certification();
            newCertification.setId(certifModel.getCertificationId());
            newCertification.setCertificationName(certifModel.getCertificationName());
            newCertification.getUsers().add(user);
            user.getCertifications().add(certificationRepository.save(newCertification));
            userRepository.save(user);

            return newCertification.getId();
        });
    }
}
