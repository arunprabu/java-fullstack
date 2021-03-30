package com.examples.spring.boot.rest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.examples.spring.boot.rest.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void addEmployee(Employee emp)
	{
		String query = "INSERT INTO EMPLOYEE(NAME, AGE, GENDER, CONTRACTOR, DESIGNATION, DEPARTMENT, ADDRESS, COUNTRY) VALUES(?,?,?,?,?,?,?,?)";
		System.out.println(query);
		int count = jdbcTemplate.update(query,emp.getName(),emp.getAge(),emp.getGender(),emp.isContractor(),emp.getDesignation(),emp.getDepartment(),emp.getAddress(),emp.getCountry());
		System.out.println(count + " Employee added");
	
	}
	
	public void updateEmployee(Employee emp)
	{
//		System.out.println("Employee updated");
	}
	
	public List<Employee> listEmployees()
	{
		List<Employee> employees = jdbcTemplate.query("SELECT * FROM EMPLOYEE", new EmployeeMapper());
		return employees;
	}
	
	public Employee getEmployeeById(int id)
	{
		return null;
	}
	
	public void removeEmployee(int id)
	{
	}
	
	private class EmployeeMapper implements RowMapper<Employee>
	{

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setId(rs.getInt("id"));
			employee.setName(rs.getString("name"));
			return employee;
		}		
	}
}
