package com.example.webcv.controllers;

import com.example.webcv.entities.User;
import com.example.webcv.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping (path = "/users", method = RequestMethod.GET)
    public Iterable<User> retrieveUsers(){
        return userService.retrieveAll();
    }

}
