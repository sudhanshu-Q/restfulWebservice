package com.rest.webservice.restful_Webservices.jpa.Student;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservice.restful_Webservices.user.User;
import com.rest.webservice.restful_Webservices.user.UserDaoService;
import com.rest.webservice.restful_Webservices.user.UserNotFound;

import jakarta.validation.Valid;

@RestController
public class StudentResource {

	// Constructor injection
	private StudentDaoService service;

	public StudentResource(StudentDaoService service) {
		this.service = service;
	}

	// Get/user
	@GetMapping("/st/students")
	public List<Student> retrieveAllUsers() {
		return service.findAll();
	}

	// Get/user/{number}
	@GetMapping("/st/students/{id}")
	public Student retrieveUser(@PathVariable int id) {
		Student student= service.findOne(id);
		if(student==null) {
			throw new StudentNotFound("id :"+id);
		}
		return service.findOne(id);
	}

	// Post create new user
	@PostMapping("st/students")
	public ResponseEntity<Student> createUser(@Valid @RequestBody Student student) {
		Student savedUser=service.saveUser(student);
		//return URI in response for created user
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		//configure response for status and message
		return ResponseEntity.created(location).build();

	}
	
	// DELETE/user/{number}
	@DeleteMapping("st//students/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
	}
	
	//Hateoas 
	//http://localhost:8010/users
	//Entity Model
	//WebMVCLinkBuilder
	// Get/user/{number}
		@GetMapping("/st/student/entityModel/{id}")
		public EntityModel<Student> retrieveUserHateoas(@PathVariable int id) {
			Student user= service.findOne(id);
			if(user==null) {
				throw new UserNotFound("id :"+id);
			}
			EntityModel<Student> entityModel=EntityModel.of(user);
			WebMvcLinkBuilder linkBuilder=linkTo(methodOn(this.getClass()).retrieveAllUsers());
			entityModel.add(linkBuilder.withRel("all_users"));
			return entityModel;
		}

}
