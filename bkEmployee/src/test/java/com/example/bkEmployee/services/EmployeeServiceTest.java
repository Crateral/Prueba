package com.example.bkEmployee.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.example.bkEmployee.controllers.EmployeeController;
import com.example.bkEmployee.entities.Employee;

public class EmployeeServiceTest {
	
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
		Mockito.when(es.searchAll()).thenReturn(ems);
	}
	
	@Test
	void searchAll() {
		assertNotNull(ec.searchAllEmployees());
		assertFalse(ec.searchAllEmployees().isEmpty());
	}

}
