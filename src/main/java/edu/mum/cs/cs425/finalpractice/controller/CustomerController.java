package edu.mum.cs.cs425.finalpractice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.finalpractice.model.Account;
import edu.mum.cs.cs425.finalpractice.model.AccountType;
import edu.mum.cs.cs425.finalpractice.model.Customer;
import edu.mum.cs.cs425.finalpractice.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping(value= {"/customer/customerlist"})
	public ModelAndView listAllCustomer() {
		ModelAndView mv =new ModelAndView();
		List<Customer> customers = customerService.getAllCustomer();
		mv.addObject("customers",customers);
		mv.setViewName("customer/customerlist");
		return mv;
	}
	
	@GetMapping(value = "/customer/addcustomer")
	public ModelAndView addNewCustomer() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("customer", new Customer());
		modelAndView.setViewName("customer/addcustomer");
		return modelAndView;
 	}
	
	@PostMapping(value = "/customer/addcustomer")
	public String postNewCustomer(@Valid @ModelAttribute("customer") Customer customer) {
//		System.out.println(customer.getCustomerNumber());
		customerService.save(customer);
		return "redirect:/customer/customerlist";
	}
	
	@GetMapping("/customer/editcustomer/{id}")
	public ModelAndView editCustomerForm(@PathVariable long id) {
		Customer customer = customerService.getCustomerById(id);
		ModelAndView md =new ModelAndView();
		md.addObject("customer", customer);
		md.setViewName("/customer/editcustomer");
		return md;
	}
	
	@PostMapping("/customer/editcustomer")
	public String postEditCustomer(@Valid @ModelAttribute("customer") Customer customer) {
		customerService.save(customer);
		return "redirect:/customer/customerlist";
	}
}
