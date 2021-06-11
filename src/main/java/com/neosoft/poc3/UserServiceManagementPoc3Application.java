package com.neosoft.poc3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class UserServiceManagementPoc3Application {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceManagementPoc3Application.class, args);
		System.out.println("hello there");

	}

}
