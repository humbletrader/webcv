package com.example.webcv.certification;

import com.example.webcv.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserCertificationServiceImpl implements UserCertificationService{

    private final UserRepository userRepository;

    private final UserCertificationRepository userCertificationRepository;

    public UserCertificationServiceImpl(UserRepository userRepository, UserCertificationRepository userCertificationRepository){
        this.userRepository = userRepository;
        this.userCertificationRepository = userCertificationRepository;
    }

    @Override
    public Optional<Integer> addCertification(Integer userId, CertificationModel certifModel) {
        return userRepository.findById(userId).map(user -> {

            //todo: check if the certification already exists
            Certification newCertification = new Certification();
            newCertification.setId(certifModel.getCertificationId());
            newCertification.setCertificationName(certifModel.getCertificationName());
            newCertification.getUsers().add(user);
            user.getCertifications().add(userCertificationRepository.save(newCertification));
            userRepository.save(user);

            return newCertification.getId();
        });
    }

    @Override
    public Iterable<CertificationModel> retrieveCertifications(Integer userId) {
        Iterator<Certification> certifications =  userCertificationRepository.findAllCertificationsForUser(userId).iterator();
        List<CertificationModel> result = new ArrayList<>();
        for(;certifications.hasNext();){
            result.add(new CertificationModel(certifications.next()));
        }
        return result;
    }
}
