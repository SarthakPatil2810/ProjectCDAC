package com.app.dao;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.Address;
import com.app.pojos.Role;
import com.app.pojos.User;

@SpringBootTest
class UserDaoTests {

	@Autowired
	private UserRepository userRepo;

	@Test
	void testAddUser() {

		Address a1 = new Address("TagorNagar", "Nashik", "MH", "India");

		User users = new User("Tushar", "Shirsath", LocalDate.parse("1997-04-14"), a1, "tushi@yahoo.com", "nikh",
				"7028022133", Role.CUSTOMER);

		// User user = userRepo.findById(2).get(); // System.out.println(user); // //
		users.setAddress(a1);
		userRepo.save(users);

	}

	@Test
	void getUser() {
		User user = userRepo.findById(1).get();
		System.out.println(user);
	}

//	@Test
//	void linkUserAddress() {
//		Address a1 = new Address("Wakad", "Pune", "MH", "India");
//		User user = userRepo.findById(1).get();
//		System.out.println(user);
//		user.setAddress(a1);
//		userRepo.save(user);
//	}

}
