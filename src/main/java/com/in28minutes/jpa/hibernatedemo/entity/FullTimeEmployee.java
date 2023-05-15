package com.in28minutes.jpa.hibernatedemo.entity;

import jakarta.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee{

    private int salary = 50000;

    public FullTimeEmployee(String name) {
        super(name);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
