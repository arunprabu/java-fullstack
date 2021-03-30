package com.examples.empapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.examples.empapp.exception.DataException;
import com.examples.empapp.model.Employee;

public class EmployeeDaoJdbcImpl implements EmployeeDao{

	@Autowired
	Connection conn;
	Statement stmt = null;
	ResultSet rs = null;

	public EmployeeDaoJdbcImpl() {

	}

	public boolean create(Employee employee) throws DataException {
		// INSERT employee data
		boolean status = false;
		try {
			stmt = conn.createStatement();

			String query = "INSERT INTO employee(name, age, department, designation, country) values(\""
					+ employee.getName() + "\"," + employee.getAge() + ",\"" + employee.getDepartment() + "\",\""
					+ employee.getDesignation() + "\",\"" + employee.getCountry() + "\")";

			status = stmt.execute(query);
		} catch (SQLException e) {
			
			throw new DataException(e.getMessage(), e);
		}
		return status;
	}

	public boolean update(Employee employee) {
		// UPDATE employee data
		boolean status = false;
		try {
			stmt = conn.createStatement();

			String query = "UPDATE employee SET name = \"" + employee.getName() + "\", age = " + employee.getAge()
					+ ",department = \"" + employee.getDepartment() + "\",designation = \"" + employee.getDesignation()
					+ "\", country = \"" + employee.getCountry() + "\" WHERE id = " + employee.getEmpId();

			status = stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean delete(int id) {
		// DELETE employee data
		boolean status = false;
		try {
			stmt = conn.createStatement();

			String query = "DELETE FROM employee WHERE id = " + id;

			status = stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public Employee get(int empId) {
		// SELECT employee data
		Employee emp = null;
		String query = "SELECT * FROM employee WHERE id = " + empId;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String department = rs.getString("department");
				String designation = rs.getString("designation");
				String country = rs.getString("country");
				emp = new Employee(id, name, age, designation, department, country);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public List<Employee> getAll() {
		// SELECT All employees
		List<Employee> employees = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM employee");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String department = rs.getString("department");
				String designation = rs.getString("designation");
				String country = rs.getString("country");
				employees.add(new Employee(id, name, age, designation, department, country));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}
}