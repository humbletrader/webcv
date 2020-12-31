package com.example.webcv.certification;

import java.util.Optional;

public interface UserCertificationService {

    Optional<Integer> addCertification(Integer userId, CertificationModel certificationName);

    Iterable<CertificationModel> retrieveCertifications(Integer userId);

}
