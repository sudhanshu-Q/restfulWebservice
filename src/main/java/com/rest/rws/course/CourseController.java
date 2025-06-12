package com.rest.rws.course;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.rest.webservice.restful_Webservices.employee.EmployeeService;
import com.rest.webservice.restful_Webservices.employee.Employees;
import com.rest.webservice.restful_Webservices.user.User;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@PostMapping("/add/course")
	public Course addCourseID(@RequestBody Course course) {
		return courseService.addCourse(course);
	}

}
