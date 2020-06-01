package com.example.webcv.controllers;

import com.example.webcv.entities.User;
import com.example.webcv.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/webcv")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping (path = "/users", method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> retrieveUsers(){
        return new ResponseEntity<>(userService.retrieveAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<User> retrieveUser(@PathVariable(name = "id") Integer userId){
        User user = userService.retrieveUser(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT)); // returning 409 just for the sake of doing it
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //@RequestMapping(path = "/user", method = RequestMethod.POST)
    @PostMapping(path ="/user")
    public ResponseEntity<User> addUser(@RequestBody() User user){
        User newUser = userService.newUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

}
