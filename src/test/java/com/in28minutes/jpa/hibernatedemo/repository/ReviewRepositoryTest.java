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
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernatedemo.HibernateDemoApplication;
import com.in28minutes.jpa.hibernatedemo.entity.Course;
import com.in28minutes.jpa.hibernatedemo.entity.Review;
import com.in28minutes.jpa.hibernatedemo.entity.Student;

import jakarta.persistence.EntityManager;

@SpringBootTest(classes=HibernateDemoApplication.class)
class ReviewRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;

	@Test
	void contextLoads() {
	}
	
	@Test
	void test_findReviewAndCourse() {
		Review review = em.find(Review.class, 40001);
		logger.info("Test Review is {}", review);
		assertEquals("good", review.getRating());
		assertEquals("JPA Learning", review.getCourse().getName());
	}

}
