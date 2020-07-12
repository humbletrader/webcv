package com.example.webcv.cv;

import com.example.webcv.user.User;
import com.example.webcv.user.UserDoesNotExistException;
import com.example.webcv.user.UserModel;
import com.example.webcv.user.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CvService {

    private final UserService userService;

    public CvService(UserService userService) {
        this.userService = userService;
    }

    public CvModel retrieveCv(Integer userId) throws UserDoesNotExistException{
        UserModel user = userService.retrieveUser(userId).orElseThrow( UserDoesNotExistException::new);

        return new CvModel(user.getFirstName(), user.getLastName(), user.getPhotoLink(), user.getExperiences());
    }

}
