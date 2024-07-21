package com.rakesh.rest.webservices.restful_webservices.jpa.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rakesh.rest.webservices.restful_webservices.jpa.course.Course;

public interface CourseSpringDataJpaRepo extends JpaRepository<Course, Long>{
	
	
	List<Course> findByAuthor(String author);
	
	

}
