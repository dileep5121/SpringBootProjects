package com.wipro.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wipro.demo.dao.EmployeeRepo;

import com.wipro.demo.model.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/addemployee")
	public String addEmployee(Employee employee) {
		
		repo.save(employee);
		return "index";
	}
	
	@RequestMapping("/displayAll")
	public String getemployees(Model m,Employee employee){
		
		ArrayList<Employee> l1=new ArrayList<Employee>();
		l1=(ArrayList<Employee>) repo.findAll();
		m.addAttribute("result",l1);
		
	
		return "displayAll";
	}
	@GetMapping("/display/{empid}")
	@ResponseBody
	public Optional<Employee> getEmployee(@PathVariable("empid") int empid){		
		
	
		return repo.findById(empid);
	}

}
