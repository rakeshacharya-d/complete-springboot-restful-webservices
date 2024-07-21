package com.rakesh.rest.webservices.restful_webservices.jpa.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rakesh.rest.webservices.restful_webservices.jpa.course.Course;
import com.rakesh.rest.webservices.restful_webservices.jpa.course.springdatajpa.CourseSpringDataJpaRepo;


@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	
	
	//@Autowired
	//private CourseJdbcRepo repo;
	
	//@Autowired
	//private CourseJpaRepo repo;
	
	@Autowired
	private CourseSpringDataJpaRepo repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repo.save(new Course(10001, "Spring JPA", "Rakesh"));
		repo.save(new Course(10002, "Spring Boot", "Rakesh"));
		repo.save(new Course(10003, "Spring MVC", "Rakesh"));
		
		repo.deleteById(10002l);
		
		System.out.println(repo.findById(10001l));
		System.out.println(repo.findById(10003l));
		
		System.out.println(repo.findAll());
		
		System.out.println(repo.findByAuthor("Rakesh"));
		
		
		
		
	}
	
	

}
