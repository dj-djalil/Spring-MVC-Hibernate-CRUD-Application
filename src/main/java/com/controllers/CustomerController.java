package com.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Customer;
import com.service.CustomerService;
import com.service.CustomerServiceImp;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject the customerDAO

	private CustomerService service = new CustomerServiceImp();

	@GetMapping("/list")
	public String showList(Model model) {
		System.out.println("welcome");
		// Get Customers From DAO
		List<Customer> customers = service.getCustomers();
		System.out.println(customers.get(0).getFirstName());
		// Add Customers to the model
		model.addAttribute("customers", customers);
		return "list";
	}

	@GetMapping("/show-customer-form")
	public String showCustomerForm(Model model) {
		// binding form data
		model.addAttribute("theCustomer", new Customer());
		return "newCustomer-form";
	}

	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute("theCustomer") Customer newCustomer) {
		service.addCustomer(newCustomer);
		return "redirect:/customer/list";
	}

	@GetMapping("/show-update-form")
	public String showUpdateForm(@RequestParam("id") int id, Model model) {
		// get the customer relative to that id to show in the update form
		Customer customer = service.getCustomer(id);
		model.addAttribute("upCustomer", customer);
		return "updateCustomer-form";
	}

	// NB: You can use the same methode ("addCustomer for adding a new Customer or
	// updating a customer ") just in your DAO implementaion
	// use the methode session.saveOrUpdate() instead of session.save()
	@PostMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute("upCustomer") Customer customer) {
		service.updateCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("id")int id) {
		System.out.println(id);
		service.deleteCustomer(id);
		return "redirect:/customer/list";
	}
}
