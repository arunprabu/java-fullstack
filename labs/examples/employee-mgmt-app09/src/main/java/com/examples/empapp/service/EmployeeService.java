package com.examples.empapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.empapp.exception.ApplicationException;
import com.examples.empapp.model.Employee;
import com.examples.empapp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;

	public EmployeeService() {
	}

	public boolean create(Employee employee) throws ApplicationException {
		try {
			employeeRepo.save(employee);
			return true;
		} catch (Exception e) {
			throw new ApplicationException("Server Error. Please try after sometime. Cause: " + e.getMessage(), e);
		}
	}

	public Employee get(int id) {
		return employeeRepo.getOne(id);
	}

	public List<Employee> getAll() {
		return employeeRepo.findAll();
	}

	public boolean update(Employee employee) {
		employeeRepo.save(employee);
		return true;
	}

	public boolean delete(int id) {
		employeeRepo.deleteById(id);
		return true;
	}

}
