package com.example.bkEmployee.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.bkEmployee.entities.Employee;

@Service
@Configuration
@PropertySource("classpath:parameters.properties")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	RestTemplate rt;

	@Value("${url.all.employees}")
	private String urlAllEmployees;

	@Value("${url.employee}")
	private String urlEmployee;

	@Override
	public List<Employee> searchAll() {
		// TODO Auto-generated method stub
		String fooResourceUrl = this.urlAllEmployees;
		ResponseEntity<String> response = rt.getForEntity(fooResourceUrl, String.class);

		List<Employee> employees = new ArrayList<Employee>();
		List<JSONObject> employeesJs = new ArrayList<JSONObject>();

		JSONObject jsnobject = new JSONObject(response.getBody());
		JSONArray jsonArray = jsnobject.getJSONArray("data");

		for (int i = 0; i < jsonArray.length(); i++) {
			employeesJs.add(new JSONObject(jsonArray.get(i).toString()));
		}

		for (int i = 0; i < employeesJs.size(); i++) {
			Employee em = new Employee();
			em.setAge(employeesJs.get(i).getInt("employee_age"));
			em.setId(employeesJs.get(i).getInt("id"));
			em.setName(employeesJs.get(i).getString("employee_name"));
			em.setSalary(employeesJs.get(i).getInt("employee_salary"));
			em.setAnualSalary(employeesJs.get(i).getInt("employee_salary") * 12);
			employees.add(em);
		}

		return employees;
	}

	@Override
	public List<Employee> searchById(int id) {
		// TODO Auto-generated method stub

		List<Employee> employees = new ArrayList<Employee>();

		String fooResourceUrl = this.urlEmployee + "/" + id;
		ResponseEntity<String> response = rt.getForEntity(fooResourceUrl, String.class);

		JSONObject jsnobject = new JSONObject(response.getBody());

		JSONObject jsnobjectEm = jsnobject.getJSONObject("data");

		Employee em = new Employee();
		em.setAge(jsnobjectEm.getInt("employee_age"));
		em.setId(jsnobjectEm.getInt("id"));
		em.setName(jsnobjectEm.getString("employee_name"));
		em.setSalary(jsnobjectEm.getInt("employee_salary"));
		em.setAnualSalary(jsnobjectEm.getInt("employee_salary") * 12);

		employees.add(em);

		return employees;
	}

}
