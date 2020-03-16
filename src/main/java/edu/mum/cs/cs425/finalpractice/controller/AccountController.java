package edu.mum.cs.cs425.finalpractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.finalpractice.model.Account;
import edu.mum.cs.cs425.finalpractice.model.AccountType;
import edu.mum.cs.cs425.finalpractice.model.Customer;
import edu.mum.cs.cs425.finalpractice.service.AccountService;
import edu.mum.cs.cs425.finalpractice.service.AccountTypeService;
import edu.mum.cs.cs425.finalpractice.service.CustomerService;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private CustomerService customertService;
	@Autowired
	private AccountTypeService accountTypetService;
	
	@GetMapping("/account/accountlist")
	public ModelAndView accoutList() {
		ModelAndView md = new ModelAndView();
		List<Account> accounts = accountService.getAllAccount();
		double netLiquidity = accountService.computeNetLiquidity();
		md.addObject("accounts",accounts);
		md.addObject("net", netLiquidity);
		md.setViewName("/account/accountlist");
		return md;
	}

	@GetMapping("/account/addaccount")
	public ModelAndView addAccountForm() {
		ModelAndView md =new ModelAndView();
		md.addObject("account", new Account());
		List<Customer> customers =customertService.getAllCustomer();
		md.addObject("customers",customers);
		List<AccountType> accountTypes = accountTypetService.getAllAccountType();
		md.addObject("accountTypes",accountTypes);
		md.setViewName("/account/addaccount");
		return md;
	}
	
	@PostMapping("/account/addaccount")
	public String postNewAccount(@ModelAttribute("account") Account account) {
		accountService.save(account);
		return "redirect:/account/accountlist";
	}
	

	@GetMapping("/account/editaccount/{id}")
	public ModelAndView editAccountForm(@PathVariable long id) {
		Account account = accountService.getAccountById(id);
		ModelAndView md =new ModelAndView();
		md.addObject("account", account);
		List<Customer> customers =customertService.getAllCustomer();
		md.addObject("customers",customers);
		List<AccountType> accountTypes = accountTypetService.getAllAccountType();
		md.addObject("accountTypes",accountTypes);
		md.setViewName("/account/editaccount");
		return md;
	}
	
	@PostMapping("/account/editaccount")
	public String postEditAccount(@ModelAttribute("account") Account account) {
		accountService.save(account);
		return "redirect:/account/accountlist";
	}
	
	
}
