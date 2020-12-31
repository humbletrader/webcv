package com.example.webcv.certification;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/webcv")
public class UserCertificationController {

    private final UserCertificationService userCertificationService;

    public UserCertificationController(UserCertificationService userCertificationService){
        this.userCertificationService = userCertificationService;
    }

    @GetMapping(path = "/users/{id}/certifications")
    public ResponseEntity<Iterable<CertificationModel>> retrieveCertifications(@PathVariable(name = "id") Integer userId){
        return new ResponseEntity<>(userCertificationService.retrieveCertifications(userId), HttpStatus.OK);
    }

    @PostMapping(path = "/users/{id}/certifications")
    public ResponseEntity<Integer> addCertification(@PathVariable(name = "id") Integer userId,
                                                    @RequestBody() CertificationModel certifModel){
        Optional<Integer> id = userCertificationService.addCertification(userId, certifModel);
        return new ResponseEntity<>(id.orElse(-1), HttpStatus.CREATED);
    }

}
