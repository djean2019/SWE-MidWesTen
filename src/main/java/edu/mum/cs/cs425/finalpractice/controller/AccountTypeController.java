package edu.mum.cs.cs425.finalpractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.finalpractice.model.AccountType;
import edu.mum.cs.cs425.finalpractice.service.AccountTypeService;

@Controller
public class AccountTypeController {
	@Autowired
	private AccountTypeService accountTypeService;
	
	@GetMapping("/accounttype/accounttypelist")
	public ModelAndView listAccountType() {
		ModelAndView mv=new ModelAndView();
		List<AccountType> accounttypes = accountTypeService.getAllAccountType();
		mv.addObject("accounttypes", accounttypes);
		mv.setViewName("/accounttype/accounttypelist");
		return mv;
	}
}
