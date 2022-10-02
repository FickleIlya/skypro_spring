package com.example.ficklecalculator.Services;

import com.example.ficklecalculator.Employee.Employee;

import java.util.List;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalary(Integer departmentId);
    Employee getEmployeeWithMinSalary(Integer departmentId);
    List<Employee> getAllEmployeesInDepartment(Integer departmentId);

    List<List<Employee>> getAllEmployeesInDepartment();
}
