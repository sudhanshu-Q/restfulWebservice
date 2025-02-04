package com.rest.webservice.restful_Webservices.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservice.restful_Webservices.jpa.UserRepositoryJpa;
import com.rest.webservice.restful_Webservices.user.UserDaoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class EmployeesController {
	
	@Autowired
	private EmployeeService employeeService;
	
	public EmployeesController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping("/add/emp")
	public Employees addEmp(@RequestBody Employees employees) {
		return employeeService.addEmployee(employees);
	}
	
	@GetMapping("/get/emp")
	@CrossOrigin(origins = "http://localhost:8010/")
	public List<Employees> getEmp() {
		return employeeService.getEmployees();
		
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/get/emp/page")
	public Model employeePage(Model model) {
		return model;
	}

}
