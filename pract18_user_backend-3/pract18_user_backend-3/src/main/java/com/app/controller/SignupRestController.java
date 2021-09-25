package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/signup")
//@CrossOrigin(origins = "http://localhost:3000")
public class SignupRestController {
	@Autowired
	private IUserService userService;

	public SignupRestController() {
		System.out.println("in constructor of " + getClass().getName());
	}
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody @Valid User user) {
		System.out.println("in save user " + user);
		return new ResponseEntity<>(userService.saveUserDetails(user), HttpStatus.CREATED);
	}
	@GetMapping
	public List<User> getAllUsers() {
		System.out.println("in getAllUsers " + getClass().getName());
		return userService.fetchAllUsers();
	}
}
