package com.bridgelabz.demo.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.demo.model.Greeting;
import com.bridgelabz.demo.model.User;
@Service
public interface IGreetingService {

	Greeting addGreeting(User user);
	Greeting getGreetingById(long id);
	List<Greeting> getAllGreetings();
	String deleteGreeting(Long id);
	Greeting updateGreeting(Long id, String message);
}
