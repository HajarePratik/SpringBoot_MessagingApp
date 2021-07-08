package com.bridgelabz.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.demo.model.Greeting;

@RestController
public class GreetingController 
{
	
	private static final String templete = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name",defaultValue = "Pratik")String name)
	{
		return new Greeting(counter.incrementAndGet(),
				String.format(templete, name));
	}
	
	

	
}
