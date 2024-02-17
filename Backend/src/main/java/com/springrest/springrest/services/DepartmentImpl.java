package com.springrest.springrest.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.Department;
import com.springrest.springrest.dao.DepartmentDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	public List<Department> getDepartment() {
		return departmentDao.findAll();
	}

	
	@Override
	public Department getDepartmentById(long id) {
		return departmentDao.findById(id).get();
	}

	@Override
	public Department createDepartment(Department depart) {
		departmentDao.save(depart);
		return depart;
	}

	@Override
	public Department updateDepartment(long id, Department updateDepart) {
		departmentDao.save(updateDepart);
		return updateDepart;
	}

	
	@Override
	public void deleteDepartment(long id) {
		Department entity = departmentDao.findById(id).get();
		departmentDao.delete(entity);
	}
	
	
	

}
