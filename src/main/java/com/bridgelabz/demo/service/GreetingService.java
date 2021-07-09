package com.bridgelabz.demo.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.demo.model.Greeting;
import com.bridgelabz.demo.model.User;
import com.bridgelabz.demo.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService{

	private static final String templete = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired(required = true)
	private GreetingRepository greetingRepository;
	
	@Override
	public Greeting addGreeting(User user) {
		String message = String.format(templete,(user.toString().isEmpty())?"Hello World" :user.toString());
		return greetingRepository.save(new Greeting(counter.incrementAndGet(),message));
	}


	@Override
	public Greeting getGreetingById(long id) {
		
		return greetingRepository.findById(id).get();
	}
	
	@Override
	public List<Greeting> getAllGreetings() {
		return greetingRepository.findAll();
	}

	@Override
	public String deleteGreeting(Long id) {
		greetingRepository.deleteById(id);
		return "Deleted Successfully";
	}

	@Override
	public Greeting updateGreeting(Long id, String message) {
		Greeting greet = this.getGreetingById(id);
		greet.setMessage(message);
		greetingRepository.save(greet);
		return this.getGreetingById(id);
	}

}
