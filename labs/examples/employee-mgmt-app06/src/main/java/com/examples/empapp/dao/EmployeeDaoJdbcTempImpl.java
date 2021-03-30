package com.examples.empapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.examples.empapp.exception.DataException;
import com.examples.empapp.model.Employee;

public class EmployeeDaoJdbcTempImpl implements EmployeeDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	NamedParameterJdbcTemplate namedJdbcTemplate;

	@Override
	public boolean create(Employee employee) throws DataException {
		String query = "INSERT INTO employee(name, age, department, designation, country) values(\""
				+ employee.getName() + "\"," + employee.getAge() + ",\"" + employee.getDepartment() + "\",\""
				+ employee.getDesignation() + "\",\"" + employee.getCountry() + "\")";
		
		jdbcTemplate.execute(query);
		return true;
	}

	@Override
	public boolean update(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee get(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAll() {
		String query = "SELECT * FROM EMPLOYEE";
		List<Employee> employees = jdbcTemplate.query(query, new EmployeeMapper());
		return employees;
	}
	
	private class EmployeeMapper implements RowMapper<Employee>
	{

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setEmpId(rs.getInt("id"));
			employee.setName(rs.getString("name"));
			employee.setAge(rs.getInt("Age"));
			employee.setDesignation(rs.getString("designation"));
			employee.setDepartment(rs.getString("department"));
			employee.setCountry(rs.getString("country"));
			return employee;
		}		
	}	

	
}
