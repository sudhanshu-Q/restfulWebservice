package com.rest.webservice.restful_Webservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import jakarta.validation.Valid;

@Component
public class UserDaoService {
	// Dao service is to manage user class details
	// JPA/Hibernate> DataBase
	// UserDaoService > static List
    private static int userCount=3;
	
	private static List<User> users = new ArrayList<>();
	static {
		users.add(new User(++userCount, "user1", LocalDate.now().minusYears(34)));
		users.add(new User(++userCount, "user2", LocalDate.now().minusYears(30)));
		users.add(new User(++userCount, "user3", LocalDate.now().minusYears(23)));
		users.add(new User(++userCount, "user4", LocalDate.now().minusYears(15)));
	}

	// retrieve List of users
	public List<User> findAll() {
		return users;
	}

	// retrieve one user by id
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);

	}
	
	//Create new User
	public User saveUser(@Valid User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
		
	}
	
	// Delete one user by id
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);

	}

}
