package com.app.service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.User;


@SpringBootTest
class UserServiceTests {

	@Autowired
	private IUserService userService;

	@Test
	void testfetchAllUser() {
	List<User>	users = userService.fetchAllUsers();
	 assertTrue(3==users.size());
	}

}
   