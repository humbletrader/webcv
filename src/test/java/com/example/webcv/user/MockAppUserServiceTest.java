package com.example.webcv.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MockAppUserServiceTest {

    @Autowired
    MockUserService mockUserService;

    @Test
    void retrieveAllUsers() {
        mockUserService.retrieveAllUsers();
        System.out.println("running a test for retrieveAllUsers");
    }
}