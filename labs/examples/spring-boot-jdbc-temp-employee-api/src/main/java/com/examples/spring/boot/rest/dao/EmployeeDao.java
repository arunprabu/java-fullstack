package com.examples.spring.boot.rest.dao;

import java.util.List;

import com.examples.spring.boot.rest.model.Employee;


public interface EmployeeDao {
	
	public void addEmployee(Employee emp);
	public void updateEmployee(Employee emp);
	public List<Employee> listEmployees();
	public Employee getEmployeeById(int id);
	public void removeEmployee(int id);
}
