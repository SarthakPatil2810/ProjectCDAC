package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.pojos.Bookings;

public interface IBookingService {

	public List<Bookings> fetchAllBookings();
	public Bookings getBookingById(int id);
	public String deleteBooking(int id);
public Bookings saveBooking(Bookings booking);
public List<Bookings> showBookingByDate(LocalDate date);
}
