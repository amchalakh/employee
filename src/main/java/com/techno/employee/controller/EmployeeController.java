package com.techno.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techno.employee.entity.Employee;
import com.techno.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/add-employee")
	public String addEmployee(@RequestBody Employee employee){
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/get-employees")
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@GetMapping("/get-emplyees-bycity")
	public List<Employee> getEmployeeByCity(@RequestParam String city){
		return employeeService.getEmployeeByCity(city);
	}
	
	
	@PutMapping("/update-employee")
	public String updateEmployee(@RequestBody Employee employee){
		return employeeService.updateEmploee(employee);
	}
	
	@DeleteMapping("/delete-mapping")
	public String deleteEmployee(@RequestParam int id){
		return employeeService.deleteEmployee(id);
	}

}
