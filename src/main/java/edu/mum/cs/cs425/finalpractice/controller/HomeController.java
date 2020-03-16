package edu.mum.cs.cs425.finalpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String getHomePage() {
		return "home/index";
	}
}
