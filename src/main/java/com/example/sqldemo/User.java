package com.example.sqldemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String department;

    private String name;

    
    public User() {
    }

	public User(String department, String name) {
		super();
		this.department = department;
		this.name = name;
	}
  
    
    
}
