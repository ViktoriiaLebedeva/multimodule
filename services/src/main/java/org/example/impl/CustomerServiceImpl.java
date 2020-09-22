package org.example.impl;


import org.example.Customer;
import org.example.CustomerIdGenerator;
import org.example.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
	private CustomerIdGenerator customerIdGenerator;
	private List<Customer> customers = new ArrayList<>();

	@Autowired
	public CustomerServiceImpl(CustomerIdGenerator customerIdGenerator) {
		this.customerIdGenerator = customerIdGenerator;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		customer.setId(Integer.toString(customerIdGenerator.generateNextId()));
		customers.add(customer);
		return customer;
	}

	@Override
	public Optional<Customer> findCustomer(String id) {
		return customers.stream()
			.filter(customer -> customer.getId().equals(id))
			.findFirst();
	}

	@Override
	public List<Customer> getCustomers() {
		return customers;
	}

	@Override
	public void updateCustomer(Customer customer) {
		customers.set(customers.indexOf(customer), customer);
	}
}
