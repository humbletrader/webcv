package com.example.webcv.user;

import com.example.webcv.experience.ExperienceModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(path = "/webcv")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    //check below for a simple usage ( shortcat GetMapping)
    @RequestMapping (path = "/users", method = RequestMethod.GET)
    public ResponseEntity<Iterable<UserModel>> retrieveUsers(){
        return new ResponseEntity<>(userService.retrieveAllUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<UserModel> retrieveUser(@PathVariable(name = "id") Integer userId){
        UserModel user = userService.retrieveUser(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT)); // returning 409 just for the sake of doing it
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //@RequestMapping(path = "/user", method = RequestMethod.POST)
    @PostMapping(path ="/users")
    public ResponseEntity<Integer> addUser(@RequestBody() UserModel user){
        Integer newUserId = userService.newUser(user);
        return new ResponseEntity<>(newUserId, HttpStatus.CREATED);
    }

    @PutMapping(path = "/users")
    public ResponseEntity<Integer> modifyUser(@RequestBody() UserModel userModel){
        ResponseEntity<Integer> response;
        try {
            Integer affectedUserId = userService.updateUser(userModel);
            response = new ResponseEntity<>(affectedUserId, HttpStatus.ACCEPTED);
        } catch (Exception exception) {
            response = new ResponseEntity<>(-1, HttpStatus.CONFLICT);
        }
        return response;
    }

    @DeleteMapping(path = "/users/{userId}")
    public ResponseEntity<Integer> deleteUser(@PathVariable Integer userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    @PostMapping(path = "/users/{id}/experience")
    public ResponseEntity<Integer> addExperience(@PathVariable(name = "id") Integer userId,
                                                 @RequestBody() ExperienceModel experience){

        Optional<Integer> expId = userService.addExperience(userId, experience);
        return new ResponseEntity<>(expId.orElse(-1), HttpStatus.CREATED);
    }

}
