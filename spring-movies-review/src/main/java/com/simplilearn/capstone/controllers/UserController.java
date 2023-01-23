package com.simplilearn.capstone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.capstone.dao.UserRepository;
import com.simplilearn.capstone.model.User;
import com.simplilearn.capstone.responseType.Status;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/users/add")
	public User addUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping("/users/all")
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	@DeleteMapping("/users/delete/{userId}")
	public Status deleteUser(@PathVariable int userId) {
		Status status = new Status();
		try {
			userRepository.deleteById(userId);
			status.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status.setSuccess(false);
		}
		
		return status;
	}
	
	@PostMapping("/users/signin")
	public User signIn(@RequestBody User user) {
		return userRepository.findByUserEmailAndUserPassword(user.getUserEmail(), user.getUserPassword());
	}
	
	

}
