package com.sales.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sales.models.Customer;
import com.sales.services.CustomerService;

@Controller
@SessionAttributes({"order", "product", "customer", "customerNames", "productNames"})
public class CustomerController {
	
	@Autowired
	CustomerService cs;

	// show customers - GET method
	@RequestMapping(value = "/showCustomers.html")
	public String showCustomersGET(Model m) {
				
		// Get all Customers and store them in the ArrayList
		ArrayList<Customer> customers = cs.findAll();
		
		// Adding data to the model
		m.addAttribute("customers", customers);		
		
		// displays showCustomers.jsp
		return "showCustomers";
	}
	
	// add customer
	@RequestMapping(value = "/addCustomer.html", method=RequestMethod.GET)
	public String addCustomerGET(Model model) {
		// new Customer Object
		Customer c = new Customer();
		
		// Adding data to the model
		model.addAttribute("customer", c);

		// displays addCustomer.jsp
		return "addCustomer";
	}
	
	// add Customer
	@RequestMapping(value = "/addCustomer.html", method=RequestMethod.POST)
	public String addCustomerPOST(@Valid @ModelAttribute("customer") Customer c, BindingResult result) {
		  		
		// check for errors
		if(result.hasErrors()) {
			// displays addCustomer.jsp
			return "addCustomer";
		}
		else {
			// save the new Customer - saveCustomer is in the CourseService class
			cs.saveCustomer(c);
			
			// change URL to addStudent.html - down below
			return "redirect:showCustomers.html";			
		}
	}
	
	
}