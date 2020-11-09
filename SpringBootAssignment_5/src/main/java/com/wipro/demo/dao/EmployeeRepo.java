package com.wipro.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.demo.model.Employee;



public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
