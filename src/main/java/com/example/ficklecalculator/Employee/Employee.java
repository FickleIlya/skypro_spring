package com.example.ficklecalculator.Employee;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
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
