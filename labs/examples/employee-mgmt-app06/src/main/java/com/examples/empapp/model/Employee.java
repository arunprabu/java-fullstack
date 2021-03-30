package com.examples.empapp.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;



/**
 * Models employee object
 */
@XmlRootElement
public class Employee {

	private int empId;
	@NotEmpty(message = "Employee Name can't be empty.")
	private String name;
	@NotNull(message = "Age can't be empty.")
	@Min(value = 18, message ="Age should be more than 18 years.")
	private int age;
	private String department;
	private String designation;
	private String country;
	
	public Employee()
	{
		
	}
	
	public Employee(int empId, String name, int age, String department, String designation, String country)
	{
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.department = department;
		this.designation = designation;
		this.country = country;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
