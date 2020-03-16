package edu.mum.cs.cs425.finalpractice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.finalpractice.model.Customer;
import edu.mum.cs.cs425.finalpractice.repository.CustomerRepository;
import edu.mum.cs.cs425.finalpractice.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository=customerRepository;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(long id) {
		return customerRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
	}
	
}
