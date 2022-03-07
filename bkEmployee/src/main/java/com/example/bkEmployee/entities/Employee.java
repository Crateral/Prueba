package com.example.bkEmployee.entities;

public class Employee {
	
	private int id;
	
	private String name;
	
	private int age;
	
	private int salary;
	
	private int anualSalary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAnualSalary() {
		return anualSalary;
	}

	public void setAnualSalary(int anualSalary) {
		this.anualSalary = anualSalary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salaty=" + salary + ", anualSalary="
				+ anualSalary + "]";
	}

	
	
}
