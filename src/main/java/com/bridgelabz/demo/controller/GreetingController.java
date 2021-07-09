package com.bridgelabz.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.demo.model.Greeting;
import com.bridgelabz.demo.model.User;
import com.bridgelabz.demo.service.IGreetingService;

@RestController
@RequestMapping("/greetings")
public class GreetingController 
{
	@Autowired
	private IGreetingService greetingService;
	
	@GetMapping("")
	public Greeting greeting(@RequestParam(value="fname",defaultValue = "Pratik")String fname,@RequestParam(value="lname",defaultValue = "Hajare")String lname)
	{
		User user = new User();
		user.setFirstName(fname);
		user.setLastName(lname);
		return greetingService.addGreeting(user);
	}
	
	

	
}
