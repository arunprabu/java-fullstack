package com.examples.empapp.dao;

import java.util.List;

import com.examples.empapp.exception.DataException;
import com.examples.empapp.model.Employee;

public interface EmployeeDao {

	public boolean create(Employee employee) throws DataException;
	public boolean update(Employee employee);
	public boolean delete(int id);
	public Employee get(int empId);
	public List<Employee> getAll();
}
