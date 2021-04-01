package com.examples.empapp.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.examples.empapp.model.ResponseMessage;

@ControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseMessage> handleAppExcpetion(Exception e) {
		ResponseMessage resMsg = new ResponseMessage("Failure", new String[] {e.getMessage()}, ExceptionUtils.getStackTrace(e));
		return ResponseEntity.badRequest().body(resMsg);
	}
	

}
