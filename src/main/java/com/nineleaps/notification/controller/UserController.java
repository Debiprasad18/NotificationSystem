package com.nineleaps.notification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nineleaps.notification.model.User;
import com.nineleaps.notification.service.UserService;

@RestController(value = "/users")
public class UserController {

	private final UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@PostMapping(path = "/create")
	public User create(@RequestBody User user) {
		return service.save(user);
	}

	@GetMapping(path = "/findAll")
	public List<User> findAll(){
		return service.findAll();
	}
	
	@PutMapping(path = "/registerAdmin")
	public User registerAdmin(@RequestBody User user) {
		return service.update(user);
	}
	
	@PutMapping(path = "/deregisterAdmin")
	public User deregisterAdmin(@RequestBody User user) {
		return service.update(user);
	}
}
