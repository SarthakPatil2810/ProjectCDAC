package com.app.service;

import java.util.List;

import com.app.pojos.Bookings;
import com.app.pojos.Customer;

public interface ICustomerService {

	public Customer saveCustomerDetails(Customer customer);
	public Bookings saveBookingDetails(Bookings bookings) ;
	public String deleterPetDetails(int petId);
	public Customer getUserById(int id);
	public Customer updatePetDetails(Customer cust);
	public List <Customer> fetchAllCustomer();
	public Customer getCustomerById(int id);  
}
