package com.in28minutes.jpa.hibernatedemo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@NamedQuery(name="query_get_all_courses", query = "select c from Course c")
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<>();
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students;

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
	}
	
	public Course() {
	}

	public Course(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course [" + name + "]";
	}

}
