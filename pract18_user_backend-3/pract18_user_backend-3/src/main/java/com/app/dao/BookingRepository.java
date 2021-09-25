package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Bookings;

public interface BookingRepository extends JpaRepository<Bookings, Integer>{

	
	@Query(value = "select b from Bookings b where b.bookingFrom=:bookingFrom")
	List<Bookings> showBookingByDate(@Param("bookingFrom")LocalDate date);
	
}
