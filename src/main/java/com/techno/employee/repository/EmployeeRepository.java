package com.techno.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techno.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByCity(String city);
}
