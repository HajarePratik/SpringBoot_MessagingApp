package com.bridgelabz.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/")
	public Greeting greeting(@RequestParam(value="fname",defaultValue = "Pratik")String fname,@RequestParam(value="lname",defaultValue = "Hajare")String lname)
	{
		User user = new User();
		user.setFirstName(fname);
		user.setLastName(lname);
		return greetingService.addGreeting(user);
	}
	
	@GetMapping("/{id}")
	public String getGreeting(@PathVariable Long id) {
		return greetingService.getGreetingById(id).getMessage();	
	}
	
	@GetMapping("/getAll")
	public List<Greeting> getAllGreeting() {
		return greetingService.getAllGreetings();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteGreeting(@PathVariable Long id) {
		return greetingService.deleteGreeting(id);
	}
	
	@PutMapping("/put")
	public Greeting updateGreeting(@RequestParam(value = "id") Long id,
			@RequestParam(value = "message", defaultValue = "")String message) {
		return greetingService.updateGreeting(id, message);		
	}
	
	

	
}
