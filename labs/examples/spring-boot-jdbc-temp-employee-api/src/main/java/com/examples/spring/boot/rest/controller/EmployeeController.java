package com.examples.spring.boot.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examples.spring.boot.rest.model.Employee;
import com.examples.spring.boot.rest.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
//	Create Employee 	POST	/employees
//	Get All Employees	GET		/employees
//	Update Employee		PUT		/employees/{id}
//	Delete Employee		DELETE	/employees/{id}
//	Get Employee		GET		/employees/{id}
	
	@PostMapping
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee)
	{
		empService.add(employee);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	@GetMapping
	public List<Employee> getAll()
	{
		return empService.list();
	}	

	@PutMapping("/{id}")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee, @PathVariable int id)
	{
		employee.setId(id);
		empService.update(employee);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id)
	{
		empService.delete(id);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable int id)
	{
		return empService.get(id);
	}		

}
