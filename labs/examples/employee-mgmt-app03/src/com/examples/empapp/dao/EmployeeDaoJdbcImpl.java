package com.examples.empapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.examples.empapp.model.Employee;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class EmployeeDaoJdbcImpl implements EmployeeDao {

	MysqlDataSource datasource = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	public EmployeeDaoJdbcImpl() {
		datasource = new MysqlDataSource();
		datasource.setServerName("localhost");
		datasource.setDatabaseName("jdbctraining");
		datasource.setUser("training");
		datasource.setPassword("training");

		try {
			conn = datasource.getConnection();
			System.out.println("Connection created successfully. " + conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean create(Employee employee) {
		// INSERT employee data
		boolean status = false;
		try {
			stmt = conn.createStatement();

			String query = "INSERT INTO employee(name, age, designation, department, country) values(\""
					+ employee.getName() + "\"," + employee.getAge() + ",\"" + employee.getDesignation() + "\",\""
					+ employee.getDepartment() + "\",\"" + employee.getCountry() + "\")";

			status = stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean update(Employee employee) {
		// UPDATE employee data
		boolean status = false;
		try {
			stmt = conn.createStatement();

			String query = "UPDATE employee SET name = \"" + employee.getName() + "\", age = " + employee.getAge()
					+ "\",designation = \"" + employee.getDesignation() + ",department = \"" + employee.getDepartment()
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
				String designation = rs.getString("designation");
				String department = rs.getString("department");
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
				String designation = rs.getString("designation");				
				String department = rs.getString("department");
				String country = rs.getString("country");
				employees.add(new Employee(id, name, age, designation, department, country));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}
}