package com.springrest.springrest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.services.EmployeeService;

import lombok.RequiredArgsConstructor;

//EmployeeController.java
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmployeeController {

 @Autowired	
 private EmployeeService employeeService;
 
 
 @GetMapping("/employees")
 public List<Employee> getAllEmployees() {
     return this.employeeService.getAllEmployees();
 }

 @GetMapping("/employees/{employeeId}")
 public ResponseEntity<Employee> getEmployeeById(@PathVariable long employeeId) {
	 Employee employee = employeeService.getEmployeeById(employeeId);
	 if(employee == null)
		 return ResponseEntity.notFound().build();
	 return ResponseEntity.ok(employee);
 }

 @PostMapping("/employees")
 public Employee createEmployee(@RequestBody Employee employee) {
    
     return employeeService.createEmployee(employee);
 }

 @PutMapping("employees/{employeeId}")
 public ResponseEntity<Employee> updateEmployee(@PathVariable long employeeId,@RequestBody Employee employee) {
	 Employee existingEmployee = employeeService.getEmployeeById(employeeId);
	 if(existingEmployee == null)
		 return ResponseEntity.notFound().build();
	 existingEmployee.setName(employee.getName());
	 existingEmployee.setContact(employee.getContact());
	 existingEmployee.setJobType(employee.getJobType());
	 existingEmployee.setDepartment(employee.getDepartment());
	 existingEmployee.setJobPosition(employee.getJobPosition());
	 existingEmployee.setLocation(employee.getLocation());
	 
	 Employee updatedEmployee = employeeService.updateEmployee(existingEmployee);
	 
	 return ResponseEntity.ok(updatedEmployee);
 }

 @DeleteMapping("employees/{employeeId}")
 public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId) {
     Employee existingEmployee = employeeService.getEmployeeById(employeeId);
     if(existingEmployee == null)
    	 return ResponseEntity.notFound().build();
     employeeService.deleteEmployee(employeeId);
     return ResponseEntity.ok().build();
 }

 

}
