package com.wipro.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wipro.demo.dao.EmployeeRepo;
import com.wipro.demo.model.Employee;


@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepo repo;
	
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/addemployee")
	public String addEmployees(Employee employee) {
		
		repo.save(employee);
		return "index";
	}
	@GetMapping("/employee")
public String getemployees(Model m,Employee employee){
		
		ArrayList<Employee> l1=new ArrayList<Employee>();
		l1=(ArrayList<Employee>) repo.findAll();
		m.addAttribute("result",l1);
		
	
		return "displayAll";
	}
	@GetMapping("/employee/{empid}")
	@ResponseBody
	public Optional<Employee> getEmployee(@PathVariable("empid") int empid){
		
		
	
		return repo.findById(empid);
	}
	@PostMapping(path="/employee",consumes= {"application/json"})
	@ResponseBody
	public Employee addEmployee(@RequestBody Employee employee){
		repo.save(employee);
		
	
		return employee;
	}
	@DeleteMapping("/employee/{empid}")
	@ResponseBody
	
	public String deleteAlien(@PathVariable int empid) {
		Employee a=repo.getOne(empid);
		repo.delete(a);
		
		return "deleted";
	}
	@PutMapping(path="/employee",consumes= {"application/json"})
	@ResponseBody
	public Employee saveOrUpdate(@RequestBody Employee employee){
		repo.save(employee);
		
	
		return employee;
	}


}
