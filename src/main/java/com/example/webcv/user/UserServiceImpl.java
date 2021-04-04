package com.example.webcv.user;


import com.example.webcv.certification.UserCertificationRepository;
import com.example.webcv.company.Company;
import com.example.webcv.company.CompanyRepository;
import com.example.webcv.experience.Experience;
import com.example.webcv.experience.ExperienceModel;
import com.example.webcv.experience.UserExperienceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final CompanyRepository companyRepository;

    private final UserRepository userRepository;

    private final UserExperienceRepository userExperienceRepository;

    private final UserCertificationRepository userCertificationRepository;

    //autowiring of parameters done by default by spring (since 4.x or something)
    public UserServiceImpl(CompanyRepository companyRepository,
                           UserExperienceRepository userExperienceRepository,
                           UserCertificationRepository userCertificationRepository,
                           UserRepository userRepository) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
        this.userExperienceRepository = userExperienceRepository;
        this.userCertificationRepository = userCertificationRepository;
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
                    userModel.getPhotoLink(),
                    userModel.getVersion()
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


}
