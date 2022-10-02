package com.example.ficklecalculator.Employee;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;

    private int department;
    private float salary;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public float getSalary() {return salary;}
    public int getDepartment() {return department;}

    public void setSalary(float salary) {this.salary = salary;}
    public void setDepartment(int department) {this.department = department;}

    public Employee(String firstName, String lastName, int department, float salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "FIO: " + firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }
}
