package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sales.models.Customer;

@Repository 
public interface CustomerRepository extends CrudRepository <Customer, Long>{

	// Long is the primary key type in the Customer class
}
