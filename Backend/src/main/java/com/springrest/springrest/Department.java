package com.springrest.springrest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//Department.java

@Data
@Entity
@Table(name="department")
public class Department {
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String name;
 
public Department() {
	super();
}

public Long getId() {
	return id;
}
//public void setId(Long id) {
//	this.id = id;
//}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

 
 
 

 // Constructors, getters, and setters
}
