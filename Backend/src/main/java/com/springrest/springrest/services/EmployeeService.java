package com.springrest.springrest.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.springrest.springrest.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(long employeeId);
	public Employee createEmployee(Employee employee);
	public void deleteEmployee(Long employeeId);
	public Employee updateEmployee(Employee employee);
}
