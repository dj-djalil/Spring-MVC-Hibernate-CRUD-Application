package com.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.model.Customer;

@Component
public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void addCustomer(Customer newCustomer);

	public Customer getCustomer(int id);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(int id);

}
