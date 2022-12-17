package com.techno.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techno.employee.entity.Employee;
import com.techno.employee.exception.EmployeeNotFoundException;
import com.techno.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;

	public String addEmployee(Employee employee) {
		
		repo.save(employee);
		
		return "Employee saved successfully";
	}

	public List<Employee> getEmployees() {
		return repo.findAll();
		
	}

	public String updateEmploee(Employee employee) {
		repo.save(employee);
		return "Employee updated successfully";
	}

	public String deleteEmployee(int id) {
		try{
			
		repo.deleteById(id);
		return "Employee deleted successfully";
		}catch(Exception e){
			throw new EmployeeNotFoundException();
		}
	}

	public List<Employee> getEmployeeByCity(String city) {
		return repo.findByCity(city);
	}

}
