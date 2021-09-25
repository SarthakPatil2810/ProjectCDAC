package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.Address;
import com.app.pojos.Customer;
import com.app.pojos.Role;
import com.app.pojos.User;

@SpringBootTest
class CustomerDaoTests {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CustomerRepository custRepo;

	/*
	 * @Test void testAddUser() {
	 * 
	 * Address a1 =new Address("Wakad", "Pune", "MH", "India");
	 * 
	 * User users = new User("yyy1", "Shinde", LocalDate.parse("1997-04-14"),a1,
	 * "yyyy1@yahoo.com", "nikh", "7028022133", Role.CUSTOMER);
	 * 
	 * // User user = userRepo.findById(2).get(); // System.out.println(user); // //
	 * users.setAddress(a1); userRepo.save(users);
	 * 
	 * }
	 */
	@Test
	void addCustomer() {
		User user = userRepo.findById(10).get();
		System.out.println(user);
		Customer cust1 = new Customer("Picxy", "Dog", "Mari_gold", null, null, user);
		custRepo.save(cust1);
	}

	@Test
	void getUser() {
		List<Customer> cust = custRepo.findAll();
		cust.forEach((temp) -> {
			System.out.println(temp);
		});
	}
//	@Test
//	void linkUserAddress() {
//		Address a1 = new Address("Wakad", "Pune", "MH", "India");
//		User user = userRcue(user);
//	}

}
