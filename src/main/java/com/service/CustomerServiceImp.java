package com.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CustomerDAO;
import com.dao.CustomerDAOImpl;
import com.model.Customer;

@Service
public class CustomerServiceImp implements CustomerService {

	// Hard Coded Shoud Inject  CustomerDAO implementation
	private   CustomerDAO customerDAO = new CustomerDAOImpl();
	//@Transactional
	public List<Customer> getCustomers() {
		 
		return customerDAO.getCustomers();
	}
	public void addCustomer(Customer newCustomer) {
		 customerDAO.addCustomer(newCustomer);
		
	}
	public Customer getCustomer(int id) {
		 
		return customerDAO.getCustomer(id);
	}
	public void updateCustomer(Customer customer) {
		 
		customerDAO.updateCustomer(customer);
	}
	public void deleteCustomer(int id) {
		 customerDAO.deleteCustomer(id);
		
	}

}
