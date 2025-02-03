package com.rest.webservice.restful_Webservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.webservice.restful_Webservices.user.User;

public interface UserRepositoryJpa extends JpaRepository<User, Integer> {

}
