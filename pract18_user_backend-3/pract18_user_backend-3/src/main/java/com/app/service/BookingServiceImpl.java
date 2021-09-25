package com.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BookingRepository;
import com.app.pojos.Bookings;
@Service
@Transactional

public class BookingServiceImpl implements IBookingService {

	@Autowired
	BookingRepository bookRepo; 
	
	public BookingServiceImpl() {
		
	}

	@Override
	public List<Bookings> fetchAllBookings() {
		
		return bookRepo.findAll();
	}

	@Override
	public Bookings getBookingById(int id) {
		
		return bookRepo.findById(id).get();
	}

	@Override
	public String deleteBooking(int id) {
		bookRepo.deleteById(id);
		return "Booking deleted Successfully!!" ;
	}

	@Override
	public Bookings saveBooking(Bookings booking) {
		// TODO Auto-generated method stub
		return bookRepo.save(booking);
	}

	@Override
	public List<Bookings> showBookingByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return bookRepo.showBookingByDate(date);
	}

}
