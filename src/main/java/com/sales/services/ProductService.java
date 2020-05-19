package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.repositories.ProductRepository;

@Service 
public class ProductService {
	
	@Autowired
	ProductRepository pr;

	// used to get all products from the database
	public ArrayList<Product> findAll() {
		return (ArrayList<Product>) pr.findAll();
	}
	
	// for adding a Product
	public void saveProduct(Product p) {
		pr.save(p);
	}
	
	// method to find one Product
    public Product findOne(Long pId){  
        return pr.findOne(pId);
    }
}