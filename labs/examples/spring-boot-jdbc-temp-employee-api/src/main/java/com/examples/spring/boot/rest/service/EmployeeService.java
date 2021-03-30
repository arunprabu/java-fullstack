package com.examples.spring.boot.rest.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.spring.boot.rest.dao.EmployeeDao;
import com.examples.spring.boot.rest.model.Employee;

@Service
public class EmployeeService {

//	private static Map<String, Employee> employees = new LinkedHashMap<String, Employee>();
	
	@Autowired
	EmployeeDao employeeDao;

	public void add(Employee employee) {

//		employee.setId(UUID.randomUUID().toString());
//
//		employees.put(employee.getId(), employee);
//		
//		return employee.getId();
		employeeDao.addEmployee(employee);
	}

	public void update(Employee employee) {

//		employees.put(employee.getId(), employee);
		
		employeeDao.updateEmployee(employee);
	}

	public Employee get(int empId) {
//		return employees.get(empId);
		return employeeDao.getEmployeeById(empId);
	}

	public void delete(int empId) {
//		employees.remove(empId);
		employeeDao.removeEmployee(empId);
	}

	public List<Employee> list() {
//		return new ArrayList<Employee>(employees.values());
		return employeeDao.listEmployees();
	}

}
