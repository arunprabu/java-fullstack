package com.examples.empapp.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;

/**
 * Handles requests for the employee management.
 */
@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	@Qualifier("employeeValidator")
	private Validator validator;

	@Autowired
	EmployeeService empService;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@ModelAttribute("genderOptions")
	public Map<String, String> getGenderOptions() {
		Map<String, String> genderOptions = new LinkedHashMap<String, String>();
		genderOptions.put("M", "Male");
		genderOptions.put("F", "Female");
		return genderOptions;
	}

	@ModelAttribute("countries")
	public Map<String, String> getCountries() {
		Map<String, String> getCountries = new LinkedHashMap<String, String>();
		getCountries.put("India", "India");
		getCountries.put("USA", "USA");
		getCountries.put("UK", "UK");
		getCountries.put("China", "China");
		return getCountries;
	}
	
	@ModelAttribute("skillList")
	public List<String> getSkills() {
		List<String> skillList = new ArrayList();
		skillList.add("Technical");
		skillList.add("Functional");
		skillList.add("Managerial");
		skillList.add("Process");
		return skillList;
	}	

	@ModelAttribute("employee")
	public Employee creatEmployeeModel() {
		return new Employee();
	}

	@GetMapping
	public ModelAndView showAddForm() {

		return new ModelAndView("addEmployee");
	}

	@PostMapping
	public String addEmployee(@ModelAttribute("employee") Employee employee, BindingResult bindingResult) {

		validator.validate(employee, bindingResult);

		if (bindingResult.hasErrors()) {
			return "addEmployee";
		}

		empService.add(employee);

		return "redirect:/employee/list";
	}

	@GetMapping(value = "/update/{id}")
	public ModelAndView showEditForm(@PathVariable String id) {

		Employee employee = empService.get(id);
		return new ModelAndView("updateEmployee", "employee", employee);
	}

	// @PutMapping(value = "/update")
	@PostMapping(value = "/update")
	public String updateEmployee(@ModelAttribute Employee employee, BindingResult bindingResult) {

		validator.validate(employee, bindingResult);

		if (bindingResult.hasErrors()) {
			return "updateEmployee";
		}
		
		empService.update(employee);
		
		return "redirect:/employee/list"; 
	}

	@GetMapping(value = "/delete/{id}")
	public ModelAndView deleteEmployee(@PathVariable String id) {

		empService.delete(id);
		return new ModelAndView("redirect:/employee/list");
	}

	@GetMapping(value = "/list")
	public ModelAndView listEmployees() {

		List<Employee> empList = empService.list();

		// ModelAndView model = new ModelAndView();
		// model.setViewName("listEmployees");
		// model.addObject("empList", empList);

		return new ModelAndView("listEmployees", "empList", empList);
	}

}
