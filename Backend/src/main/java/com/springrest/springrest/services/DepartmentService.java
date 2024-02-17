package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.Department;

public interface DepartmentService {
	public List<Department> getDepartment();
	public Department getDepartmentById(long id);
	public Department createDepartment(Department depart);
	public Department updateDepartment(long id, Department updateDepart);
	public void deleteDepartment(long id);
}
