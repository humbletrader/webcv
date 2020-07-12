package com.example.webcv.cv;

import com.example.webcv.user.UserDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/webcv")
public class CvController {

    public final CvService cvService;

    public CvController(CvService cvService) {
        this.cvService = cvService;
    }

    @GetMapping(path = "/cv/{userId}")
    public ResponseEntity<CvModel> retrieveCv(@PathVariable(name = "userId") Integer userId){
        try {
            CvModel cv = cvService.retrieveCv(userId);
            return new ResponseEntity<>(cv, HttpStatus.OK);
        } catch(UserDoesNotExistException userDoesNotExistExc){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
