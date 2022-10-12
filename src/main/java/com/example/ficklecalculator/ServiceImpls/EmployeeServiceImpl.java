package com.example.ficklecalculator.ServiceImpls;

import com.example.ficklecalculator.Employee.Employee;
import com.example.ficklecalculator.Exceptions.EmployeeAlreadyAddedException;
import com.example.ficklecalculator.Exceptions.EmployeeNotFoundException;
import com.example.ficklecalculator.Services.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>(); // change to list

    @Override
    public List<Employee> allEmployees(){
        return employees;
    }
    @Override
    public Employee addEmployee(String firstName, String lastName, int department, float salary){
        Optional<Employee> employee = employees.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findFirst();

        if (employee.isPresent()){
            throw new EmployeeAlreadyAddedException();
        }
        Employee newEmployee = new Employee(firstName, lastName, department, salary);
        employees.add(newEmployee);
        return newEmployee;
    }

    @Override
    public String removeEmployee(String firstName, String lastName){
        Optional<Employee> employee = employees.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findFirst();

        if (employee.isEmpty()){
            throw new EmployeeNotFoundException();

        }
        employees.remove(employee.get());
        return "Employee " + employee.get().getFirstName() + " " + employee.get().getLastName() + " removed";

    }

    @Override
    public Employee findEmployee(String firstName, String lastName){
        Optional<Employee> employee = employees.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findFirst();

        if (employee.isEmpty()){
            throw new EmployeeNotFoundException();
        }
        return employee.get();
    }
}
