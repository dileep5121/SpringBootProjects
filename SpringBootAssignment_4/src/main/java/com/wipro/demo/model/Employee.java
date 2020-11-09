package com.wipro.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private int empid;
	private String empname;
	private String empemail;
	private String location;
	public Employee() {
		super();
		
	}
	public Employee(int empid, String empname, String empemail, String location) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empemail = empemail;
		this.location = location;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpemail() {
		return empemail;
	}
	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empemail=" + empemail + ", location=" + location
				+ "]";
	}
	
	

}
