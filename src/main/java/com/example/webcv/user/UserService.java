package com.example.webcv.user;


import com.example.webcv.company.Company;
import com.example.webcv.company.CompanyRepository;
import com.example.webcv.experience.Experience;
import com.example.webcv.experience.ExperienceModel;
import com.example.webcv.experience.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private CompanyRepository companyRepository;

    private UserRepository userRepository;

    private ExperienceRepository experienceRepository;

    public UserService(CompanyRepository companyRepository, ExperienceRepository experienceRepository, UserRepository userRepository){
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
        this.experienceRepository = experienceRepository;
    }

    public Iterable<UserModel> retrieveAll() {
        List<UserModel> result = new ArrayList<>();
        Iterator<User> users = userRepository.findAll().iterator();
        for (Iterator<User> it = users; it.hasNext(); ) {
            result.add(new UserModel(it.next()));
        }
        return result;
    }

    public Optional<UserModel> retrieveUser(Integer userId){
        return userRepository.findById(userId).map(UserModel::new);
    }

    public Integer newUser(UserModel userModel){
        User newUser = new User();
        newUser.setUsername(userModel.getUsername());
        return userRepository.save(newUser).getId();
    }

    public Optional<Integer> addExperience(Integer userId, ExperienceModel newExperience){

        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Integer> expId = optionalUser.map(
                user -> {
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
        return  expId;
    }

}
