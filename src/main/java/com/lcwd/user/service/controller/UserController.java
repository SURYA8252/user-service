package com.lcwd.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.entites.User;
import com.lcwd.user.service.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
    private UserService userService;
	//User Create
	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User saveUser = this.userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
	}
	//get single user
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
		User userById = this.userService.getUserById(userId);
		return ResponseEntity.ok(userById);
	}
	//Get all user
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUser = this.userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}
}
