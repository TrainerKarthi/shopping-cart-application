package com.vk.service;

import java.util.List;

import com.vk.dto.Customer;

public interface CustomerService {
	public Customer saveCustomer(Customer p);

	public Customer findCustomerById(int id);

	public List<Customer> findAllCustomers();

	public boolean updateCustomerById(int id, Customer p);

}
