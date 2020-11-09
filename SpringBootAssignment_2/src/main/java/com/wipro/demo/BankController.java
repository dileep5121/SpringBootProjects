package com.wipro.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankController {
	
	@RequestMapping("/")
	public String getBranches() {
		
		return "branches";
	}
	
	@RequestMapping("/services")
	public String getServices() {
		
		return "services";
	}

}
