package edu.mum.cs.cs425.finalpractice.service;

import java.util.List;

import edu.mum.cs.cs425.finalpractice.model.Customer;

public interface CustomerService {
	public abstract List<Customer> getAllCustomer();
	public abstract Customer getCustomerById(long id);
	public abstract void save(Customer customer);
}
