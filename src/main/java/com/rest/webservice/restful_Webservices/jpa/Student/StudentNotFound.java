package com.rest.webservice.restful_Webservices.jpa.Student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class StudentNotFound extends RuntimeException {
	
	public StudentNotFound(String message) {
		super(message);
	}

}
