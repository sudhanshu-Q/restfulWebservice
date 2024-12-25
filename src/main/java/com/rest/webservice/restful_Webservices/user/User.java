package com.rest.webservice.restful_Webservices.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "User_details")
public class User {
	// member variable in our user class
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 3,max = 20,message = "min lenght is 3 and max is 20")
	@JsonProperty("User_name")//Customized field name in response
	private String name;
	
	@Past(message = "BirthDate should be in past date")
	@JsonProperty("birth_date")
	private LocalDate birthDate;

	// Constructor for user class
	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
