package com.example.bkEmployee.services;

import java.util.List;

import com.example.bkEmployee.entities.Employee;

public interface EmployeeService {

	List<Employee> searchAll();
	List<Employee> searchById(int id);
	
}
