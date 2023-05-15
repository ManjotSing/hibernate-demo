package com.in28minutes.jpa.hibernatedemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;

@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String rating;
	
	private String description;
	
	@ManyToOne
	private Course course;
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Review() {
	}

	public Review(String rating, String desc) {
		this.rating = rating;
		this.description = desc;
	}

	public Long getId() {
		return id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}

	@Override
	public String toString() {
		return "Review [" + rating + "]";
	}

}
