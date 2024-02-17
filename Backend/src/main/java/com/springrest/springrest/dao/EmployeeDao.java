package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Long> {

}