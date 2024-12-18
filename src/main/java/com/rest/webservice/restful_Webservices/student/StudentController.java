package com.rest.webservice.restful_Webservices.student;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservice.restful_Webservices.helloWorld.HelloWorldBean;

@RestController
public class StudentController {
	
	//path parameter
	@GetMapping(path = "/student/{name}")
		public StudentRepository getStudentDetails(@PathVariable String name) {
		//String.format("Get detail of : $s", name);
			return new StudentRepository("Welcome ",name);
		}
//	@GetMapping(path = "/student/{name}")
//	public Model getStudentDetailsView(@PathVariable String name,Model model) {
//	//String.format("Get detail of : $s", name);
//		return model;
//		//return new StudentRepository("Welcome ",name);
	}
	
