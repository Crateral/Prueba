package com.example.bkEmployee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bkEmployee.entities.Employee;
import com.example.bkEmployee.services.EmployeeService;

@CrossOrigin(origins="http://localhost:4200", maxAge=3600)
@RestController
@RequestMapping({"/employee"})
public class EmployeeController {

	EmployeeService es;
	
	@Autowired
	public EmployeeController(EmployeeService es2) {
		this.es = es2;
	}
	@GetMapping
	public List<Employee> searchAllEmployees(){
		return es.searchAll();
		
	}
	@GetMapping(path = {"/{id}"})
	public List<Employee> searchEmployeeById(@PathVariable("id")int id) {
		return es.searchById(id);
	}
}
