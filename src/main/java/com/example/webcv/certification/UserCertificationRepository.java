package com.example.webcv.certification;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UserCertificationRepository extends CrudRepository<Certification, Integer> {

    @Query("select c from Certification c join c.appUsers u where u.id = :userId")
    Iterable<Certification> findAllCertificationsForUser(@Param("userId") Integer userId);
}
