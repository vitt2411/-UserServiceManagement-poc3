package com.neosoft.poc3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.neosoft.poc3.controller.UserController;

@SpringBootApplication
@EnableJpaRepositories
public class UserServiceManagementPoc3Application {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceManagementPoc3Application.class, args);

	}

}
