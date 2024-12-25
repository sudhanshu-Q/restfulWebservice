package com.rest.webservice.restful_Webservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	// Constructor injection
	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}

	// Get/user
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	// Get/user/{number}
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user= service.findOne(id);
		if(user==null) {
			throw new UserNotFound("id :"+id);
		}
		return service.findOne(id);
	}

	// Post create new user
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser=service.saveUser(user);
		//return URI in response for created user
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		//configure response for status and message
		return ResponseEntity.created(location).build();

	}
	
	// DELETE/user/{number}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
	}
	
	//Hateoas 
	//http://localhost:8010/users
	//Entity Model
	//WebMVCLinkBuilder
	// Get/user/{number}
		@GetMapping("/users/entityModel/{id}")
		public EntityModel<User> retrieveUserHateoas(@PathVariable int id) {
			User user= service.findOne(id);
			if(user==null) {
				throw new UserNotFound("id :"+id);
			}
			EntityModel<User> entityModel=EntityModel.of(user);
			WebMvcLinkBuilder linkBuilder=linkTo(methodOn(this.getClass()).retrieveAllUsers());
			entityModel.add(linkBuilder.withRel("all_users"));
			return entityModel;
		}

}
