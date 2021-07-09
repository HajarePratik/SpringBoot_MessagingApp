package com.bridgelabz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan("com.bridgelabz.demo")
@EnableJpaRepositories("com.bridgelabz.demo.repository")
@SpringBootApplication
public class SpringBootMessagingAppApplication {

	public static void main(String[] args) {
		System.out.println("Welcome To Greeting Messaging App");
		SpringApplication.run(SpringBootMessagingAppApplication.class, args);
	}

}
