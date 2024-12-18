package com.rest.webservice.restful_Webservices.user;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser=service.saveUser(user);
		//return URI in response for created user
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		//configure response for status and message
		return ResponseEntity.created(location).build();

	}

}
