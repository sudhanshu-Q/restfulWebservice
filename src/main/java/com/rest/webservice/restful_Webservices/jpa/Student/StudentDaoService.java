package com.rest.webservice.restful_Webservices.jpa.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.rest.webservice.restful_Webservices.user.User;

@Component
public class StudentDaoService {
	// Dao service is to manage user class details
	// JPA/Hibernate> DataBase
	// UserDaoService > static List
    private static int userCount=3;
	
	private static List<Student> student = new ArrayList<>();
	static {
		student.add(new Student(++userCount, "user1", LocalDate.now().minusYears(34)));
		student.add(new Student(++userCount, "user2", LocalDate.now().minusYears(30)));
		student.add(new Student(++userCount, "user3", LocalDate.now().minusYears(23)));
		student.add(new Student(++userCount, "user4", LocalDate.now().minusYears(15)));
	}

	// retrieve List of users
	public List<Student> findAll() {
		return student;
	}

	// retrieve one user by id
	public Student findOne(int id) {
		Predicate<? super Student> predicate = user -> user.getId().equals(id);
		return (Student) student.stream().filter(predicate).findFirst().orElse(null);

	}
	
	//Create new User
	public Student saveUser(Student students) {
		students.setId(++userCount);
		student.add(students);
		return (Student) student;
		
	}
	
	// Delete one user by id
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		student.removeIf((Predicate<? super Student>) predicate);

	}

}