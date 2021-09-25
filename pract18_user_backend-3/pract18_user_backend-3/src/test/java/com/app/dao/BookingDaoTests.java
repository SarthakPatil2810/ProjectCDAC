package com.app.dao;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.Address;
import com.app.pojos.Bookings;
import com.app.pojos.Customer;
import com.app.pojos.PetHostel;
import com.app.pojos.Role;
import com.app.pojos.User;

@SpringBootTest
class BookingDaoTests {

	@Autowired
	private HostelRepository hostRepo;
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BookingRepository bookRepo;
	@Autowired
	private CustomerRepository custRepo;

//	@Test
//	void addCustomerDetails() {
////		User user = userRepo.findById(4).get();
//		Customer cust = custRepo.findById(16).get();
//		PetHostel petHost = hostRepo.findById(6).get();
//		Bookings booking = new Bookings(LocalDate.parse("2021-09-09"), LocalDate.parse("2021-12-12"), true, petHost,
//				cust);
//		bookRepo.save(booking);
//
//	}
	@Test
	void deleteBooking() {
		bookRepo.deleteById(13);
	}
	// @Test
	/*
	 * void testHostelBooking() { Customer cus = custRepo.getById(1); Bookings b =
	 * new Bookings(null, null, false, null, cus) cus.addBooking(null);
	 */
}
