package com.examples.empapp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.examples.empapp.model.Employee;

@Component(value = "employeeValidator")
public class EmployeeValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		return Employee.class.isAssignableFrom(arg0);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "age.required", "Field age is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "gender.required", "Field gender is required.");
		
		Employee employee = (Employee) target;
		if(employee.getAge() != null && employee.getAge() < 0)
		{
			errors.rejectValue("age", "age.negative", "Age should not be negative value.");
		}	
		
	}

}
