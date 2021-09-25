package com.app.dao;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.Address;
import com.app.pojos.PetHostel;
import com.app.pojos.Role;
import com.app.pojos.User;

@SpringBootTest
class PetHostelDaoTests {

	@Autowired
	private HostelRepository hostRepo;
	@Autowired
	private UserRepository userRepo;

	@Test
	void testAddHostel() {

		User user = userRepo.findById(3).get();
		System.out.println(user);
		PetHostel host = new PetHostel("Jay", null, "123456789123", 1500, true, 50, 900, false, null, user);
//		 User user = userRepo.findById(2).get(); // System.out.println(user); //
//		users.setAddress(a1)
		System.out.println(host);
		hostRepo.save(host);

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
