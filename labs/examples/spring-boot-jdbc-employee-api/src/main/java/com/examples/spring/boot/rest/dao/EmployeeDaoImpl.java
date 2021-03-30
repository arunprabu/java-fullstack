package com.examples.spring.boot.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examples.spring.boot.rest.model.Employee;
import com.examples.spring.boot.rest.util.DataSource;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public EmployeeDaoImpl()
	{
		
	}
		
	@Autowired
	public EmployeeDaoImpl(DataSource datasource)
	{
		conn = datasource.getConnection();
	}
	
	@Override
	public void addEmployee(Employee employee) {
		String query = "INSERT INTO employee(name, age, department, designation, country, contractor) values(\""
				+ employee.getName() + "\"," + employee.getAge() + ",\"" + employee.getDepartment() + "\",\""
				+ employee.getDesignation() + "\",\"" + employee.getCountry() + "\"," + employee.isContractor() + ")";
		
//		String query = "INSERT INTO EMPLOYEE(NAME, AGE, GENDER, CONTRACTOR, DESIGNATION, DEPARTMENT, ADDRESS, COUNTRY) VALUES(?,?,?,?,?,?,?,?)";
		System.out.println("Create query: " + query);
		int count = 0;
		try {
			stmt = conn.createStatement();
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, employee.getName());
//			pstmt.setInt(2, employee.getAge());
//			pstmt.setString(3, employee.getGender());
//			pstmt.setBoolean(4, employee.isContractor());
//			pstmt.setString(5, employee.getDesignation());
//			pstmt.setString(6, employee.getDepartment());
//			pstmt.setString(7, employee.getAddress());
//			pstmt.setString(8, employee.getCountry());
			
//			count = pstmt.executeUpdate(query);
			count = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> listEmployees() {
		List<Employee> employees = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM employee");
			
			System.out.println("Query Executed");

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				System.out.println("Processing Employee ID " + employee.getId());
				employee.setName(rs.getString("name"));
				employee.setAge(rs.getInt("age"));
				employee.setDepartment(rs.getString("department"));
				employee.setDesignation(rs.getString("designation"));
				employee.setCountry(rs.getString("country"));
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeEmployee(int id) {
		// TODO Auto-generated method stub

	}
	
	private void closeResources() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}			
		} catch (SQLException e) {
			System.out.println("Error occured while closing the Statement and ResultSet - " + e.getMessage());
			e.printStackTrace();
		}
	}

}
