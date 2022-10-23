package com.example.ficklecalculator.department.constants;

import com.example.ficklecalculator.Employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class DepartmentConstants {
    public static final Employee employee1 = new Employee("John1", "Doe", 1, 1000f);
    public static final Employee employee2 = new Employee("Jane1", "Doe", 2, 2000f);
    public static final Employee employee3 = new Employee("John2", "Doe", 3, 1000f);
    public static final Employee employee4 = new Employee("Jane2", "Doe", 4, 2000f);
    public static final Employee employee5 = new Employee("John3", "Doe", 5, 1000f);
    public static final Employee employee6 = new Employee("Jane3", "Doe", 1, 2000f);
    public static final List<Employee> employees = new ArrayList<>(List.of(employee1, employee2, employee3, employee4, employee5, employee6));

}
