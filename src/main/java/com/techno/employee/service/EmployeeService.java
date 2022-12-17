package com.techno.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
	
	@Scheduled(cron="0 57 12 * * ?",zone="IST")
	public List<Employee> getEmployees() {
		List<Employee> empList = repo.findAll();
		System.out.println("Employee List:"+empList.toString());
		return empList;
		
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
