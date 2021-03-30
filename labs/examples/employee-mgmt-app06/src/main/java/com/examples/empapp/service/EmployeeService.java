package com.examples.empapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.examples.empapp.dao.EmployeeDao;
import com.examples.empapp.exception.ApplicationException;
import com.examples.empapp.exception.DataException;
import com.examples.empapp.model.Employee;

public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	public EmployeeService() {
//		employeeDao = new EmployeeDAO();
	}

	public boolean create(Employee employee) throws ApplicationException {
		try {
			return employeeDao.create(employee);
		} catch (DataException e) {
			throw new ApplicationException("Server Error. Please try after sometime. Cause: " + e.getMessage(), e); 
		}		
	}

	public Employee get(int id) {
		return employeeDao.get(id);
	}

	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	public boolean update(Employee employee) {
		return employeeDao.update(employee);
	}

	public boolean delete(int id) {
		return employeeDao.delete(id);
	}

}
