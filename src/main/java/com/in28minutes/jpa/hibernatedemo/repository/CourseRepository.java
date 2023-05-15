package com.in28minutes.jpa.hibernatedemo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernatedemo.entity.Course;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {
	
	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	public Course save(Course course) {
		if(course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}
		return course;
	}
	
	public void deleteById(Long id) {
		Course course = em.find(Course.class, id);
		em.remove(course);
	}

}
