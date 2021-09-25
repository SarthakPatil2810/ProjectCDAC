package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bookings_table")
@NoArgsConstructor
@AllArgsConstructor
@Setter
//@Getter
public class Bookings extends BaseEntity {

	@Column(name = "booking_from")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	//@JsonFormat(pattern = "yyyy-mm-dd")
	private LocalDate bookingFrom;

	@Column(name = "booking_to")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	//@JsonFormat(pattern = "yyyy-mm-dd")
	private LocalDate bookingTo;

	@Column(name = "payment_status")
	private boolean paymentStatus;

	@ManyToOne(cascade= {CascadeType.MERGE})
	@JoinColumn(name = "hostel_id")
	@JsonIgnoreProperties("bookings")
	@JsonBackReference
	private PetHostel hostel;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	@JsonIgnoreProperties("booking")
	private Customer customer;

	public LocalDate getBookingFrom() {
		return bookingFrom;
	}

	public LocalDate getBookingTo() {
		return bookingTo;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}
	
//@JsonBackReference
	public PetHostel getHostel() {
		return hostel;
	}
	
//  @JsonBackReference
	public Customer getCustomer() {
		return customer;
	}

	
//	@Override
//	public String toString() {
//		return "Bookings [bookingFrom=" + bookingFrom + ", bookingTo=" + bookingTo + ", paymentStatus=" + paymentStatus
//				+ "]";
//	}
}
   