package com.example.webcv.company;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company, Integer> {

    @Query("select c from Company c where c.name = :compName")
    Optional<Company> findByName(@Param("compName") String companyName);
}
