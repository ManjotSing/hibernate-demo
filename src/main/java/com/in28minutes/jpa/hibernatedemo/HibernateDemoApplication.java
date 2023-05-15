package com.in28minutes.jpa.hibernatedemo;

import com.in28minutes.jpa.hibernatedemo.entity.Employee;
import com.in28minutes.jpa.hibernatedemo.entity.FullTimeEmployee;
import com.in28minutes.jpa.hibernatedemo.entity.PartTimeEmployee;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.in28minutes.jpa.hibernatedemo.entity.Course;
import com.in28minutes.jpa.hibernatedemo.repository.CourseRepository;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class HibernateDemoApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepository;

	@Autowired
	EntityManager em;

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Employee fullTimeEmployee = new FullTimeEmployee("Richard");
		Employee partTimeEmployee = new PartTimeEmployee("Billy");
		em.persist(fullTimeEmployee);
		em.persist(partTimeEmployee);
	}

}
