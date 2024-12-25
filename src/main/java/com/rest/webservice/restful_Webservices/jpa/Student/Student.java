package com.rest.webservice.restful_Webservices.jpa.Student;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Student {
	
	// member variable in our user class
		private Integer id;
		
		@Size(min = 3,max = 20,message = "min lenght is 3 and max is 20")
		@JsonProperty("Student_name")//Customized field name in response
		private String name;
		
		@Past(message = "BirthDate should be in past date")
		@JsonProperty("Student_date")
		private LocalDate birthDate;

		// Constructor for user class
		public Student(Integer id, String name, LocalDate birthDate) {
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
			return "User [Student_id=" + id + ", student_Name=" + name + ", Student_birthDate=" + birthDate + "]";
		}

	}

