package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginRequestDTO;
import com.app.pojos.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/login")
//@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	@Autowired
	private IUserService userService;

	public LoginController() {
		System.out.println("in constructor of " + getClass().getName());
	}

	@GetMapping("/{email}/{password}")//change required postmapping
	public User getUserByNames(@PathVariable String email, @PathVariable String password) {
		System.out.println("in getAllUsers " + getClass().getName());
		System.out.println(email);
		return userService.getUserByEmailAndPassword(email, password);
	}
	@PostMapping("/forgotPassword")
	public String forgotPassword(@RequestBody LoginRequestDTO req) {
		return userService.forgotPassword(req);
		
	}
}
