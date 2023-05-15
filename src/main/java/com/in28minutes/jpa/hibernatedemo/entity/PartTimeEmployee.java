package com.in28minutes.jpa.hibernatedemo.entity;

import jakarta.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee{

    private int partTimeSalary = 50;

    public PartTimeEmployee(String name) {
        super(name);
    }

    public int getPartTimeSalary() {
        return partTimeSalary;
    }

    public void setPartTimeSalary(int partTimeSalary) {
        this.partTimeSalary = partTimeSalary;
    }
}
