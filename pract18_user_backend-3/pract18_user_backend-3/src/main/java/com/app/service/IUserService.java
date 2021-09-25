package com.app.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.dto.LoginRequestDTO;
import com.app.pojos.User;

public interface IUserService {

	List<User> fetchAllUsers();
	
	//add a method to save user details
	User saveUserDetails(User transientUser);
	//add a method to get user details
	
	//add a method to get User as per first name and last name 
		User getUserByEmailAndPassword(String fn,String ln);
		User updateUserDetails(User detachUser);
		String forgotPassword(LoginRequestDTO request);
}
  	