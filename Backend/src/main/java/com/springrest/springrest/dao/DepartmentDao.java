package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Long>{

}
