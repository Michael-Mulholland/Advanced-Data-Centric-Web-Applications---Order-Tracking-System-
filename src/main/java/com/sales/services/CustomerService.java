package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.repositories.CustomerRepository;

@Service 
public class CustomerService {

	@Autowired
	CustomerRepository cr;

	// used to get all products from the database
	public ArrayList<Customer> findAll() {
		return (ArrayList<Customer>) cr.findAll();
	}
		
	// for adding a Customer
	public void saveCustomer(Customer c) {
		cr.save(c);
	}
	
	// method to find one Customer
    public Customer findOne(Long cId){  
        return cr.findOne(cId);
    }
}