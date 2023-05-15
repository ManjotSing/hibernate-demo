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
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@SpringBootTest(classes=HibernateDemoApplication.class)
class NativeQueryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;

	@Test
	void findByNativeQuery() {
		List resultList = em.createNativeQuery("select * from course", Course.class).getResultList();
		logger.info("select * from course -> {}", resultList);
	}
	
	
	@Test
	void findByNativeQuery_IndexParameter() {
		Query query = em.createNativeQuery("select * from course where id = ?", Course.class);
		query.setParameter(1, 10002L);
		List<Course> courses = query.getResultList();
		logger.info("Select c from Course c where where id -> {}", courses);
	}
	
	@Test
	void findByNativeQuery_NamedParameter() {
		Query query = em.createNativeQuery("select * from course where id = :id", Course.class);
		query.setParameter("id", 10002L);
		List<Course> courses = query.getResultList();
		logger.info("Select c from Course c where where id -> {}", courses);
	}
	
}
