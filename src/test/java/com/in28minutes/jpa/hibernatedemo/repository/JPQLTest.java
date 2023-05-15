package com.in28minutes.jpa.hibernatedemo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.in28minutes.jpa.hibernatedemo.HibernateDemoApplication;
import com.in28minutes.jpa.hibernatedemo.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@SpringBootTest(classes=HibernateDemoApplication.class)
class JPQLTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;

	@Test
	void findByJQPLQuery() {
		List resultList = em.createNamedQuery("query_get_all_courses").getResultList();
		logger.info("select c from Course c -> {}", resultList);
	}
	
	@Test
	void findByJQPLQuery_Typed() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);
		List<Course> courses = query.getResultList();
		logger.info("select c from Course c -> {}", courses);
	}
	
	
	@Test
	void findByJQPLQuery_Typed_WhereClause() {
		TypedQuery<Course> query = em.createQuery("select c from Course c where name like '%10 Steps'", Course.class);
		List<Course> courses = query.getResultList();
		logger.info("Select c from Course c where name like -> {}", courses);
	}
	
}
