package com.project.carrier;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.carrier.models.Role;
import com.project.carrier.models.User;
import com.project.carrier.services.UserService;

@SpringBootApplication
public class CarrierApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrierApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	CommandLineRunner run(UserService userService) { 
//		return args -> {
//			userService.saveRole(new Role(null, "ROLE_USER"));
//			userService.saveRole(new Role(null, "ROLE_MANAGER"));
//			userService.saveRole(new Role(null, "ROLE_ADMIN"));
//			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
//
//			userService.saveUser(new User(null, "Jhon Travolta", "jhon", "1234", new ArrayList<>()));
//			userService.saveUser(new User(null, "Will Smith", "will", "1234", new ArrayList<>()));
//			userService.saveUser(new User(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
//			userService.saveUser(new User(null, "Arnold Shwarzenegger", "arnold", "1234", new ArrayList<>()));
//
////			userService.saveUser(new User(null, "Arnold Shwarzenegger", "arnold", "1234", new ArrayList<>()));
//
//			userService.addRoleToUser("jhon", "ROLE_USER");
//			userService.addRoleToUser("jhon", "ROLE_MANAGER");
//			userService.addRoleToUser("will", "ROLE_MANAGER");
//			userService.addRoleToUser("jim", "ROLE_ADMIN");
//			userService.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");
//			userService.addRoleToUser("arnold", "ROLE_ADMIN");
//			userService.addRoleToUser("arnold", "ROLE_USER");
//
//			
//		};
//	}
	

}
