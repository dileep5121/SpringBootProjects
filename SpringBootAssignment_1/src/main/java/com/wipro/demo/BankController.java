package com.wipro.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {
	
	@RequestMapping("/")
	public String bankName() {
		
		return "State Bank Of India";
	}
	
	@RequestMapping("/address")
	public String bankAddress() {
		
		return "Bangalore";
	}

}
