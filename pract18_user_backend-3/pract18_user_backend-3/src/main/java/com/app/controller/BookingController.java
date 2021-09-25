package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Bookings;
import com.app.pojos.User;
import com.app.service.IBookingService;
import com.app.service.IUserService;

@RestController
@RequestMapping("/booking")
//@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {
	@Autowired
	private IBookingService bookingService;

	public BookingController() {
		System.out.println("in constructor of " + getClass().getName());
	}

	@GetMapping()
	public List<Bookings> fetchAllBooking() {
//		System.out.println("in getAllUsers " + getClass().getName());
//		System.out.println(email);
		return bookingService.fetchAllBookings();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?>  getBookingById(@PathVariable int id){
		return ResponseEntity.ok(bookingService.getBookingById(id));
	}
	
}