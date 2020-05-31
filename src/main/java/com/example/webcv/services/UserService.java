package com.example.webcv.services;


import com.example.webcv.entities.User;
import com.example.webcv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public Iterable<User> retrieveAll() {
        return userRepository.findAll();
    }

}
