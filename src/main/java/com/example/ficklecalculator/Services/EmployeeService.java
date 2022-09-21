package com.example.ficklecalculator.Services;

import com.example.ficklecalculator.Employee.Employee;
import com.example.ficklecalculator.Exceptions.EmployeeAlreadyAddedException;
import com.example.ficklecalculator.Exceptions.EmployeeNotFoundException;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<>();;

    public String allEmployees(){
        return new Gson().toJson(employees);
    }
    public String addEmployee(String firstName, String lastName){
        boolean check = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)) {
                check = true;
                break;
            }
        }
        if (check) {
            throw new EmployeeAlreadyAddedException();
        }

        Employee employee = new Employee(firstName, lastName);
        employees.add(employee);
        return new Gson().toJson(employee);

    }

    public String removeEmployee(String firstName, String lastName){
        boolean check = false;
        Employee employee = null;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)){
                employee = employees.get(i);
                employees.remove(i);
                check = true;
                break;
            }
        }
        if (!check) {
            throw new EmployeeNotFoundException();
        }
        return new Gson().toJson(employee);
    }

    public String findEmployee(String firstName, String lastName){
        int id = -1;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)){
                id = i;
                break;
            }
        }
        if (id == -1) {
            throw new EmployeeNotFoundException();
        }
        return new Gson().toJson(employees.get(id));
    }
}
