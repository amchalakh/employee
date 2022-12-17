package com.techno.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.techno.employee.exception.EmployeeNotFoundException;

@ControllerAdvice
public class EmployeeExceptionController {
	
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<String> exception(EmployeeNotFoundException e){
		return new ResponseEntity<String>("Employee Not Found",HttpStatus.NOT_FOUND);
	}

}
