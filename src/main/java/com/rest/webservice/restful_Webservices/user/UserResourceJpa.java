package com.rest.webservice.restful_Webservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.rest.webservice.restful_Webservices.jpa.UserRepositoryJpa;

import jakarta.validation.Valid;

@RestController
public class UserResourceJpa {

	// Constructor injection
		private UserDaoService service;
		
		private UserRepositoryJpa userRepositoryService;

		public UserResourceJpa(UserDaoService service, UserRepositoryJpa userRepositoryService) {
			this.service = service;
			this.userRepositoryService= userRepositoryService;
		}

		// Get/user
		@GetMapping("jpa/users")
		public List<User> retrieveAllUsers() {
			return userRepositoryService.findAll();
		}

		// Get/user/{number}
		@GetMapping("jpa/users/{id}")
		public User retrieveUser(@PathVariable int id) {
			User user= service.findOne(id);
			if(user==null) {
				throw new UserNotFound("id :"+id);
			}
			return service.findOne(id);
		}
		
		//JPA and JPA repository
		// Get/user/{number}
		@GetMapping("jpa/userById/{id}")
		public User retrieveUserById(@PathVariable int id) {
			Optional<User> user= userRepositoryService.findById(id);
			if(user==null) {
				throw new UserNotFound("id :"+id);
			}
			return service.findOne(id);
		}

		// Post create new user
		@PostMapping("jpa/users")
		public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
			User savedUser=service.saveUser(user);
			//return URI in response for created user
			URI location=ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(savedUser.getId()).toUri();
			//configure response for status and message
			return ResponseEntity.created(location).build();

		}
		
		// Post create new user
				@PostMapping("jpa/newUser")
				public ResponseEntity<User> createUserWithJpa(@Valid @RequestBody User user) {
					User savedUser=userRepositoryService.save(user);
					//return URI in response for created user
					URI location=ServletUriComponentsBuilder.fromCurrentRequest()
							.path("/{id}").buildAndExpand(savedUser.getId()).toUri();
					//configure response for status and message
					return ResponseEntity.created(location).build();

				}
		
		// DELETE/user/{number}
		@DeleteMapping("jpa/users/{id}")
		public void deleteUser(@PathVariable int id) {
			service.deleteById(id);
		}
		
		//Hateoas 
		//http://localhost:8010/users
		//Entity Model
		//WebMVCLinkBuilder
		// Get/user/{number}
			@GetMapping("jpa//users/entityModel/{id}")
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
