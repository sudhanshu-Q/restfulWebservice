package com.rest.webservice.restful_Webservices.helloWorld;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@RequestMapping(method = RequestMethod.GET,path = "/home")
	public Model helloworld(Model model) {;
		return model;
	}
	@RequestMapping(method = RequestMethod.GET,path = "/student")
	public Model navigateStudent(Model model) {;
		return model;
	}
	
	@GetMapping(path = "/helloworldbean")
	public HelloWorldBean helloworldBean() {
		return new HelloWorldBean("Hello World Bean");
	}


}
