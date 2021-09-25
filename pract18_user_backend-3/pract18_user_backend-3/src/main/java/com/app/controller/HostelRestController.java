package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Bookings;
import com.app.pojos.PetHostel;
import com.app.service.IBookingService;
import com.app.service.IHostelService;

@RestController
@RequestMapping("/hostel")
//@CrossOrigin(origins = "http://localhost:3000")
public class HostelRestController {

	@Autowired
	private IHostelService hostelServ;
	@Autowired
	private IBookingService bookServ;
	@PostMapping
	public ResponseEntity<?> saveHostel(@RequestBody @Valid PetHostel hostel) {
		System.out.println("in save user " + hostel);

		return new ResponseEntity<>(hostelServ.saveHostelDetails(hostel), HttpStatus.CREATED);
	}

		@GetMapping
		public List<PetHostel> getAllHostel(){
			return hostelServ.fetchAllHostels();
		}
	
		@PutMapping("/{id}")
		public ResponseEntity<?> updatePetHostelDetails(@RequestBody PetHostel detachedPetHostel,@PathVariable int id){
		PetHostel petHost = hostelServ.getPetHostelById(id);
			return ResponseEntity.ok(hostelServ.updatePetHostelDetails(detachedPetHostel));
			
		}
		@GetMapping("/bookingDate/{date}")
		public List<Bookings> showBookingsByDate(@PathVariable String date){
			LocalDate date1 = LocalDate.parse(date);
			return bookServ.showBookingByDate(date1);
		}
		@PutMapping("/updateStatus/{id}")
		public ResponseEntity<?> updateHostelStatus(@RequestBody PetHostel statusPetHostel,@PathVariable int id){
			return  ResponseEntity.ok(hostelServ.updatePetHostelDetails(statusPetHostel));
		}
		
}







