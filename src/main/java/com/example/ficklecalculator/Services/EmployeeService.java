package com.example.ficklecalculator.Services;

import com.example.ficklecalculator.Employee.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> allEmployees();

    Employee addEmployee(String firstName, String lastName, int department, float salary);

    String removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);
}
