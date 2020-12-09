package com.service;

import java.util.List;

import com.model.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public void addCustomer(Customer newCustomer);
	public Customer getCustomer(int id);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(int id);

}
