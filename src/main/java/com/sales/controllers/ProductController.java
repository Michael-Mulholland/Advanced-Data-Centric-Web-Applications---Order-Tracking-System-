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

import com.sales.models.Product;
import com.sales.services.ProductService;

@Controller
@SessionAttributes({"order", "product", "customer", "customerNames", "productNames"})
public class ProductController {
	
	@Autowired
	ProductService ps;

	// show products - GET method
	@RequestMapping(value = "/showProducts.html")
	public String showProductGET(Model m) {
		
		// Get all Products and store them in the ArrayList
		ArrayList<Product> products = ps.findAll();
		
		// Adding data to the model
		m.addAttribute("products", products);		
		
		// displays showProducts.jsp
		return "showProducts";
	}
	
	// add product
	@RequestMapping(value = "/addProduct.html", method=RequestMethod.GET)
	public String addProductGET(Model model) {
		
		// new Product Object
		Product p = new Product();
		
		// Adding data to the model
		model.addAttribute("product", p);

		// displays addProduct.jsp
		return "addProduct";
	}
	
	// add product
	@RequestMapping(value = "/addProduct.html", method=RequestMethod.POST)
	public String addProductPOST(@Valid @ModelAttribute("product") Product p, BindingResult result) {
		  	
		// check for errors
		if(result.hasErrors()) {
			// displays addProduct.jsp
			return "addProduct";
		}
		else {
			// save the new Product - saveProduct is in the CourseService class
			ps.saveProduct(p);
			
			// change URL to showProducts.html page
			return "redirect:showProducts.html";			
		}
	}
	
	
}