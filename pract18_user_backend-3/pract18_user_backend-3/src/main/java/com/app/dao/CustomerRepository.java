package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Bookings;
import com.app.pojos.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
