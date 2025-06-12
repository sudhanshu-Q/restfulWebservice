package com.rest.rws.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.webservice.restful_Webservices.employee.Employees;
import com.rest.webservice.restful_Webservices.employee.EmployeesRepository;

import jakarta.validation.Valid;

@Service
public class CourseService {

	 private static int userCount=1;
	
	@Autowired
	private CourseRepository courseRepository;
	
	//Create new Course
		public Course addCourse(@Valid Course course) {
			course.setAuthor("physics");
			course.setId(++userCount);
			course.setName("DR PHYSICS");
			courseRepository.toString();
			return course;
			
		}
	
}
