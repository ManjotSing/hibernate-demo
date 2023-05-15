package com.in28minutes.jpa.hibernatedemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String passportNumber;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Passport() {
	}

	public Passport(String name) {
		this.passportNumber = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return passportNumber;
	}

	public void setName(String name) {
		this.passportNumber = name;
	}

	@Override
	public String toString() {
		return "Passport [" + passportNumber + "]";
	}
	
	

}
