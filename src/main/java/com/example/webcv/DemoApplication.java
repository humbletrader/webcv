package com.example.webcv;

import com.example.webcv.entities.User;
import com.example.webcv.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DemoApplication {

	private final static Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository userRepository){
		return (args) -> {
			userRepository.save(new User(1, "firstone"));
			userRepository.save(new User(2, "secondone"));

			for (User user : userRepository.findAll()) {
				log.info(" user : {}", user);
			}
		};
	}


}
