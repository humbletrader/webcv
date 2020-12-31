package com.example.webcv.certification;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Primary
public class MockUserCertificationService implements UserCertificationService{

    @Override
    public Optional<Integer> addCertification(Integer userId, CertificationModel newCertification){
        return Optional.empty();
    }

    @Override
    public Iterable<CertificationModel> retrieveCertifications(Integer userId) {
        return new ArrayList();
    }
}
