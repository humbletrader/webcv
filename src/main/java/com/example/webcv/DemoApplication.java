package com.example.webcv;

import com.example.webcv.user.UserService;
import com.example.webcv.user.UserServiceImpl;
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

//	@Bean
//	public CommandLineRunner demo(UserService userService){
//		return (args) -> {
//
//

//			userService.newUser(new UserModel(1, "firstone", Collections.emptySet()));
//			userService.newUser(new UserModel(2, "secondone", Collections.emptySet()));

//			userService.addExperience(1, new ExperienceModel("exp 100"));
//			userService.addExperience(2, new ExperienceModel("exp 200"));
//
//			for (UserModel user : userService.retrieveAll()) {
//				log.info(" user : {}", user);
//			}
//
//		};
//	}


}
