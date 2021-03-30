package com.examples.spring.boot.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.spring.boot.rest.dao.EmployeeDao;
import com.examples.spring.boot.rest.model.Employee;

@Service
public class EmployeeService {

//	private static Map<String, Employee> employees = new LinkedHashMap<String, Employee>();

	@Autowired
	EmployeeDao employeeDao;
	
	public String add(Employee employee) {
		employeeDao.addEmployee(employee);
		return String.valueOf(employee.getId());
	}

	public void update(Employee employee) {

		employeeDao.updateEmployee(employee);
	}

	public Employee get(String empId) {
		return employeeDao.getEmployeeById(Integer.parseInt(empId));
	}

	public void delete(String empId) {
		employeeDao.removeEmployee(Integer.parseInt(empId));
	}

	public List<Employee> list() {
		return employeeDao.listEmployees();
	}
}
