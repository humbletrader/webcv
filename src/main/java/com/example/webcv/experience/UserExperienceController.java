package com.example.webcv.experience;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/webcv")
public class UserExperienceController {

    private static final Logger logger = LoggerFactory.getLogger(UserExperienceController.class);

    private final UserExperienceService userExperienceService;


    public UserExperienceController(UserExperienceService userExperienceService){
        this.userExperienceService = userExperienceService;
    }

    @GetMapping(path = "/users/{userId}/experience")
    public ResponseEntity<Iterable<ExperienceModel>> retrieveExperienceForUser(@PathVariable(name = "userId") Integer userId){
        return new ResponseEntity<>(userExperienceService.retrieveExperienceForUser(userId), HttpStatus.OK);
    }

    @PostMapping(path = "/users/{id}/experience")
    public ResponseEntity<Integer> addExperience(@PathVariable(name = "id") Integer userId,
                                                 @RequestBody() ExperienceModel experience){

        Optional<Integer> expId = userExperienceService.addExperience(userId, experience);
        return new ResponseEntity<>(expId.orElse(-1), HttpStatus.CREATED);
    }

    @PutMapping(path = "/users/{userId}/experience")
    public ResponseEntity<Integer> updateExperience(@PathVariable("userId") Integer userId,
                                                    @RequestBody() ExperienceModel experience){
        return userExperienceService.updateExperience(userId, experience)
                .map(expId -> {
                    logger.info("updated experience {}", experience.getExpId());
                    return new ResponseEntity<>(expId, HttpStatus.ACCEPTED);
                })
                .orElse(new ResponseEntity<>(-1, HttpStatus.CONFLICT));
    }

    @DeleteMapping(path = "/users/{userId}/experience/{expId}")
    public ResponseEntity<Integer> deleteExperience(@PathVariable(name = "userId") Integer userId,
                                                    @PathVariable(name="expId") Integer expId){
        userExperienceService.deleteExperience(userId, expId);
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }
}
