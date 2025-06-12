package com.rest.webservice.restful_Webservices.employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.webservice.restful_Webservices.user.User;

import jakarta.validation.Valid;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeesRepository employeesRepository;
	
	 private static int userCount=1;
	 
	 private static List<Employees> empl = new ArrayList<>();
		static {
			empl.add(new Employees("sud1", 1, 200, 28));
			empl.add(new Employees("dcv1", 2, 200, 28));
		//	empl.add(new Employees());
		}


	public List<Employees> getEmployees(){
		return employeesRepository.findAll();
		
	}
	
	//Create new Employees
	public Employees addEmployee(@Valid Employees employees) {
		employees.setID(++userCount);
		empl.add(employees);
		return employees;
		
	}
	

}
