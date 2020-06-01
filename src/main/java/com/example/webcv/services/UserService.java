package com.example.webcv.services;


import com.example.webcv.entities.User;
import com.example.webcv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public Iterable<User> retrieveAll() {
        return userRepository.findAll();
    }

    public Optional<User> retrieveUser(Integer userId){
        return userRepository.findById(userId);
    }

    public User newUser(User user){
        return userRepository.save(user);
    }

}
