package com.example.bkEmployee.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.bkEmployee.controllers.EmployeeController;
import com.example.bkEmployee.entities.Employee;

public class EmployeeServiceTestById {
	
	private EmployeeService es = Mockito.mock(EmployeeService.class);
	private EmployeeController ec = new EmployeeController(es);
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		List<Employee> ems = new ArrayList<Employee>();
		Employee e = new Employee();
		e.setAge(24);
		e.setAnualSalary(123123123);
		e.setId(1);
		e.setName("Cesar H");
		e.setSalary(123);
		ems.add(e);
		Mockito.when(es.searchById(1)).thenReturn(ems);
	}
	
	@Test
	void searchById() {
		assertNotNull(ec.searchEmployeeById(1));
		assertFalse(ec.searchAllEmployees().isEmpty());
	}

}
