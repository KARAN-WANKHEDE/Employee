package com.springrest.springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springrest.springrest.services.DepartmentImpl;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DepartmentController {

	@Autowired
	private DepartmentImpl departmentServices;
	
    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return this.departmentServices.getDepartment();
    }
    
   

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
       return this.departmentServices.getDepartmentById(id);
    }

    @PostMapping("/departments")
    public Department createDepartment(@RequestBody Department department) {
        return this.departmentServices.createDepartment(department);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<HttpStatus> updateDepartment(@PathVariable Long id, @RequestBody Department updatedDepart) {
    	try {
    		this.departmentServices.updateDepartment(id, updatedDepart);
    		return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable Long id) {
        try {
	    	this.departmentServices.deleteDepartment(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
    }

}

