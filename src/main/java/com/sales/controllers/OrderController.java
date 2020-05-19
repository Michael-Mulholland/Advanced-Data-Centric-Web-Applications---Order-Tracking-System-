package com.sales.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sales.exceptions.ErrorGreaterThanQuantity;
import com.sales.exceptions.ErrorNoCustProd;
import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.services.CustomerService;
import com.sales.services.OrderService;
import com.sales.services.ProductService;

@Controller
@SessionAttributes({"order", "product", "customer", "customerNames", "productNames"})
public class OrderController {
	
	// get todays date and format it
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate localDate = LocalDate.now();

	@Autowired
	OrderService os;
	
	@Autowired
	CustomerService cs;
	
	@Autowired
	ProductService ps;
	
	// show customers
	@RequestMapping(value = "/showOrders.html")
	public String showOrdersGET(Model m) {

		// Get all customers and store them in the ArrayList
		ArrayList<Order> orders = os.findAll();

		// Adding data to the model
		m.addAttribute("orders", orders);		

		// displays showCustomers.jsp
		return "showOrders";
	}

	// add order
	@RequestMapping(value = "/addOrder.html", method=RequestMethod.GET)
	public String addOrderGET(Model model) {

		// Get Customers from DB
		ArrayList<Customer> cust = cs.findAll();
			
		// Create customerList Map
		Map<Long,String> customerNames = new LinkedHashMap<Long,String>();
	
		// Add Customers to Map
		for (Customer c : cust) {
			customerNames.put(c.getcId(), c.getcName());
		}
	
		// Add countryList to Model
		model.addAttribute("customerNames", customerNames);
				
		// Get Products from DB
		ArrayList<Product> prod = ps.findAll();
				
		// Create customerList Map
		Map<Long,String> productNames = new LinkedHashMap<Long,String>();
	
		// Add Customers to Map
		for (Product p : prod) {
			productNames.put(p.getpId(), p.getpDesc());
		}
	
		// Add countryList to Model
		model.addAttribute("productNames", productNames);	
						
		// new Order Object
		Order order = new Order();
		
		// Adding data to the model
		model.addAttribute("order", order);			

		// displays addOrder.jsp
		return "addOrder";
	}

	// add order
	@RequestMapping(value = "/addOrder.html", method=RequestMethod.POST)
	public String addOrderPOST(@Valid @ModelAttribute("order") Order order, BindingResult result, Model model) { //RedirectAttributes retrib,

		// check for errors
		if(result.hasErrors()) {
			// displays addOrder.jsp
			return "addOrder";
		}
		
		try {
			// saveMethod is in the CourseService class
			os.saveOrder(order);			
		} catch (ErrorGreaterThanQuantity | ErrorNoCustProd e) {
			// Adding data to the model
			model.addAttribute("error", e);
			
			// displays addOrderError.jsp
			return "addOrderError";
		} 
		
		// change URL to addStudent.html - down below
		return "redirect:showOrders.html";			
	}	
}