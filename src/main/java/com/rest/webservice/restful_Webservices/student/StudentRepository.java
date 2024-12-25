package com.rest.webservice.restful_Webservices.student;

public class StudentRepository {
	
	private String name;
	private String message;
	
	public StudentRepository(String message, String name) {
		super();
		this.name = name;
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "StudentRepository [message=" + message + ", name=" + name + "]";
	}
	
	
	

}
