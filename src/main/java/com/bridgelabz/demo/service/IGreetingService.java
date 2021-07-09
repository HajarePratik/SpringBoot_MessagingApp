package com.bridgelabz.demo.service;

import org.springframework.stereotype.Service;

import com.bridgelabz.demo.model.Greeting;
import com.bridgelabz.demo.model.User;
@Service
public interface IGreetingService {

	Greeting addGreeting(User user);
	Greeting getGreetingById(long id);
	
}
