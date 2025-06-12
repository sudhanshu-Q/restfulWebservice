package com.rest.rws.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // @Repository annotation helps to talk to database
public class CourseRepository {


@Autowired
private JdbcTemplate springJdbcTemplate;

private static String INSERT_QUERY_withHardCoding = """
		   insert into course(id,name,author)
		         values(12,'learn java','John');
		""";

private static String INSERT_QUERY_WithoutHardCoding = """
		   insert into course(id,name,author)
		         values(?,?,?);
		""";

private static String DELETE_QUERY = """
		 delete from course where id=?;
		""";

private static String SELECT_QUERY = """
		 select * from course where id=?;
		""";

public void insert() {
	springJdbcTemplate.update(INSERT_QUERY_withHardCoding);
}

//public void insert(Course course) {
//	springJdbcTemplate.update(INSERT_QUERY_WithoutHardCoding, 
//			course.getCourseName(), course.getEnrollmentId(), course.getFaculty(),course.getPrice());
//}

public void deleteById(long id) {
	springJdbcTemplate.update(DELETE_QUERY,id);
}

public Course selectById(long id) {
	return springJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
	//result set-> bean mapping
}
}
