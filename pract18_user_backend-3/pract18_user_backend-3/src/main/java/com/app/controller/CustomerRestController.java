package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.type.CustomCollectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Bookings;
import com.app.pojos.Customer;
import com.app.pojos.PetHostel;
import com.app.pojos.User;
import com.app.service.IBookingService;
import com.app.service.ICustomerService;
import com.app.service.IHostelService;
import com.app.service.IUserService;

@RestController
@RequestMapping("/customer")
//@CrossOrigin(origins = "http://localhost:3000")
public class CustomerRestController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IHostelService hostelService;
	@Autowired
	private ICustomerService customerService;
   @Autowired
   private IBookingService bookingService;
	public CustomerRestController() {
		System.out.println("in constructor of " + getClass().getName());
	}

	@GetMapping
	public List<PetHostel> getAllHostels() {
		System.out.println("in getAllUsers " + getClass().getName());
		return hostelService.displayHostel();
	}

	@PostMapping("/booking")
	public ResponseEntity<?> saveCustomerBooking(@RequestBody @Valid Bookings booking) {
		System.out.println("in getAllUsers " + getClass().getName());
		return new ResponseEntity<>(customerService.saveBookingDetails(booking), HttpStatus.CREATED);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?>  getCustomerById(@PathVariable int id){
		return ResponseEntity.ok(customerService.getUserById(id));
	}
	@GetMapping("/allCust")
	public List<Customer> getAllCust(){
		return customerService.fetchAllCustomer();
	}
		
	

	@PostMapping
	public ResponseEntity<?> saveCustomerDetails(@RequestBody @Valid Customer customer) {

		System.out.println( );
		return new ResponseEntity<>(customerService.saveCustomerDetails(customer), HttpStatus.CREATED);

	}

		@DeleteMapping("/{petId}")
		public ResponseEntity<?> deleterPetDetails(@PathVariable int petId){
			System.out.println("petId " + petId);
			return ResponseEntity.ok(customerService.deleterPetDetails(petId));
		}
		@PutMapping()
		public ResponseEntity<?> updatePetDetails(@RequestBody Customer detachedCust){
		//	Customer existingcust = customerService.getUserById(id);
			return ResponseEntity.ok(customerService.updatePetDetails(detachedCust));
		}
		@DeleteMapping("/deleteBooking/{bookingId}")
		public ResponseEntity<?> deleteBooking(@PathVariable int bookingId){
			System.out.println("BookingId " + bookingId );
			Bookings book = bookingService.getBookingById(bookingId);
			book.setHostel(null);
			book.setCustomer(null);
			bookingService.saveBooking(book);
			return  ResponseEntity.ok(bookingService.deleteBooking(bookingId));
		}
		
		@PutMapping("/customerUpdate")
		public ResponseEntity<?> updateCustomerDetails(@RequestBody User detachedUser){
		//	Customer existingcust = customerService.getUserById(id);
			return ResponseEntity.ok(userService.updateUserDetails(detachedUser));
		}
		
}
