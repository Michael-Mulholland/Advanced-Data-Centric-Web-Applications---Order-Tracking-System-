package com.sales.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sales.exceptions.ErrorGreaterThanQuantity;
import com.sales.exceptions.ErrorNoCustProd;
import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.repositories.OrderRepository;

@Service 
public class OrderService {
	
	//private Customer customer;
	private Product product;
	
	@Autowired
	OrderRepository or;
	
	@Autowired
	CustomerService cs;
	
	@Autowired
	ProductService ps;
	
	// get todays date and format it
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate localDate = LocalDate.now();

	// used to get all products from the database
	public ArrayList<Order> findAll() {
		return (ArrayList<Order>) or.findAll();
	}
	
	// for adding a Order
	public void saveOrder(Order order) throws ErrorGreaterThanQuantity, ErrorNoCustProd {
		// set the date and format
		order.setOrderDate(dateFormat.format(localDate));
		
		// find Product ID
		product = ps.findOne(order.getProd().getpId());
		
		// I wasn't able to output the Customers ID as I deleted it from the database for testing purposes
		try {
			// try to find the Customer ID
			cs.findOne(order.getCust().getcId());
		} catch (Exception e) {
			// otherwise, throw an ErrorNoCustProd Exception	
			throw new ErrorNoCustProd("ERROR: Customer: and/or Product: " + order.getProd().getpId() + " does not exist." );
		}
		
		try {
			// set the quantity in stock if someone odered a product
			product.setQtyInStock(product.getQtyInStock() - (order.getQty()));
			// save the new order
			or.save(order);									
		} catch (Exception e) {
			// Throw an exception should the input be invalid
			throw new ErrorGreaterThanQuantity("Quantity too large: Product stock = " + (order.getProd().getQtyInStock() + order.getQty()));			
		}		
	}
}