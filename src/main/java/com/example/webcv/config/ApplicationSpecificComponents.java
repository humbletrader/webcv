package com.example.webcv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationSpecificComponents {

    @Bean
    public String buildBlah(){
        System.out.println("===================== spring is calling my bean builder method");
        return "my bean configured with java configuration";
    }

}
