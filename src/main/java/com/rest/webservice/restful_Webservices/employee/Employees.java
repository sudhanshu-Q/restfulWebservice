package com.rest.webservice.restful_Webservices.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "empl")
public class Employees {

	@Id
	private String name;
	
	private int ID;
	
	private int salary;
	
	private int age;
	
	public Employees() {

	}

	public Employees(String name, int ID, int salary, int age) {
		super();
		this.ID=ID;
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	@Override
	public String toString() {
		return "Employees [name=" + name + ", ID=" + ID + ", salary=" + salary + ", age=" + age + "]";
	}
	
}
	