package com.examples.empapp.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.examples.empapp.model.Employee;

public class EmployeeService {


	private Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
	
	public EmployeeService() {

	}
	
	public boolean add(Employee employee) {
		employee.setId(employees.size() + 1);
		employees.put(employee.getId(), employee);
		return true;
	}

	public Employee get(int id) {
		return employees.get(id);
	}

	public Collection<Employee> getAll() {
		return employees.values();
	}

	public boolean update(Employee employee) {
		employees.put(employee.getId(), employee);
		return true;
	}

	public boolean delete(Employee employee) {
		employees.remove(employee.getId());
		return true;
	}
	
}
