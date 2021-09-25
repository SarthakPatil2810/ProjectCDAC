package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custome_exception.UserHandlingException;
import com.app.dao.BookingRepository;
import com.app.dao.CustomerRepository;
import com.app.pojos.Bookings;
import com.app.pojos.Customer;

@Service
@Transactional

public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private BookingRepository bookRepo;
	

	@Override
	public Customer saveCustomerDetails(Customer customer) {
		
		return customerRepo.save(customer);
	}
	
	@Override
	public Bookings saveBookingDetails(Bookings bookings) {
		
		return bookRepo.save(bookings);
	}

	@Override
	public String deleterPetDetails(int petId) {
		// TODO Auto-generated method stub
		 customerRepo.deleteById(petId);
		 return "Pet deleted Successfully";
	}


	@Override
	public Customer updatePetDetails(Customer detachedCust) {
	
		return customerRepo.save(detachedCust);
	}

	@Override
	public Customer getUserById(int id) {
		
		return customerRepo.findById(id).get();
	}

	

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return customerRepo.findById(id).orElseThrow(()->new UserHandlingException("invalid User ID"));
	}

	@Override
	public List<Customer> fetchAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}
	
}
