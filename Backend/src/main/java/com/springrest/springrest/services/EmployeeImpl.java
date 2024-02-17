package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springrest.springrest.Employee;
import com.springrest.springrest.dao.EmployeeDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}
	
	@Override
	public Employee getEmployeeById(long employeeId) {
		return employeeDao.findById(employeeId).get();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeDao.save(employee);
	}
	
	@Override
	public void deleteEmployee(Long employeeId) {
		employeeDao.deleteById(employeeId);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
	            return employeeDao.save(employee);
	        
	}
	


}
