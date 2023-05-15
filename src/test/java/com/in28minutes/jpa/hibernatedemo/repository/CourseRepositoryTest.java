package com.in28minutes.jpa.hibernatedemo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

@SpringBootTest(classes=HibernateDemoApplication.class)
class CourseRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void test_findCourse() {
		Course course = courseRepository.findById(10001L);
		logger.info("Test Course is {}", course);
		assertEquals("JPA Learning", course.getName());
	}
	
	@Test
	@DirtiesContext
	void test_deleteCourse() {
		Course course = courseRepository.findById(10001L);
		logger.info("Test Course is {}", course);
		assertEquals("JPA Learning", course.getName());
	}

}
