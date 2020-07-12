package com.example.webcv.user;


import com.example.webcv.company.Company;
import com.example.webcv.company.CompanyRepository;
import com.example.webcv.experience.Experience;
import com.example.webcv.experience.ExperienceModel;
import com.example.webcv.experience.ExperienceRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Profile("default")
public class UserServiceImpl implements UserService {

    private final CompanyRepository companyRepository;

    private final UserRepository userRepository;

    private final ExperienceRepository experienceRepository;

    //autowiring of parameters done by default by spring (since 4.x or something)
    public UserServiceImpl(CompanyRepository companyRepository,
                           ExperienceRepository experienceRepository,
                           UserRepository userRepository){
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
        this.experienceRepository = experienceRepository;
    }

    @Override
    public Iterable<UserModel> retrieveAllUsers() {
        List<UserModel> result = new ArrayList<>();
        Iterator<User> users = userRepository.findAll().iterator();
        for (Iterator<User> it = users; it.hasNext(); ) {
            result.add(new UserModel(it.next()));
        }
        return result;
    }

    @Override
    public Optional<UserModel> retrieveUser(Integer userId){
        return userRepository.findById(userId).map(UserModel::new);
    }

    @Override
    public Integer newUser(UserModel userModel){
        User newUser = new User();
        newUser.setUsername(userModel.getUsername());
        newUser.setFirstName(userModel.getFirstName());
        newUser.setLastName(userModel.getLastName());
        newUser.setPhotoLink(userModel.getPhotoLink());
        return userRepository.save(newUser).getId();
    }

    @Override
    public Integer updateUser(UserModel userModel) throws UserDoesNotExistException {
        boolean userExists = userRepository.existsById(userModel.getId());
        if(userExists){
            User modifiedUser = new User(userModel.getId(),
                    userModel.getUsername(),
                    userModel.getFirstName(),
                    userModel.getLastName(),
                    userModel.getPhotoLink()
            );
            return userRepository.save(modifiedUser).getId();
        } else {
            throw new UserDoesNotExistException();
        }
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Optional<Integer> addExperience(Integer userId, ExperienceModel newExperience){

        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.map( user -> {
            Company company = new Company();
            //we create a new company each time
            company.setName(newExperience.getCompanyName());
            companyRepository.save(company);

            Experience exp = new Experience();
            exp.setUser(user);
            exp.setJobTitle(newExperience.getJobTitle());
            exp.setCompany(company);

            return experienceRepository.save(exp).getId();
        });
    }

}
