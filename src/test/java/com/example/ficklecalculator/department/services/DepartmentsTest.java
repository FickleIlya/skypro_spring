package com.example.ficklecalculator.department.services;

import com.example.ficklecalculator.Employee.Employee;
import com.example.ficklecalculator.Exceptions.EmployeeNotFoundException;
import com.example.ficklecalculator.ServiceImpls.DepartmentServiceImpl;
import com.example.ficklecalculator.ServiceImpls.EmployeeServiceImpl;
import com.example.ficklecalculator.Services.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class DepartmentsTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;


    @Test
    public void testGetEmployeeWithMaxSalary(){
        Employee employee1 = new Employee("John", "Doe", 1, 1000f);
        Employee employee2 = new Employee("Jane", "Doe", 1, 2000f);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        Mockito.when(employeeService.allEmployees()).thenReturn(employees);
        Assertions.assertEquals(employee2, departmentService.getEmployeeWithMaxSalary(employee2.getDepartment()));
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> departmentService.getEmployeeWithMinSalary(2));
    }

    @Test
    public void testGetEmployeeWithMinSalary(){
        Employee employee1 = new Employee("John", "Doe", 1, 1000f);
        Employee employee2 = new Employee("Jane", "Doe", 1, 2000f);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        Mockito.when(employeeService.allEmployees()).thenReturn(employees);
        Assertions.assertEquals(employee1, departmentService.getEmployeeWithMinSalary(employee1.getDepartment()));
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> departmentService.getEmployeeWithMinSalary(2));
    }

    @Test
    public void testGetAllEmployeesInDepartment(){
        Employee employee1 = new Employee("John", "Doe", 1, 1000f);
        Employee employee2 = new Employee("Jane", "Doe", 1, 2000f);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        Mockito.when(employeeService.allEmployees()).thenReturn(employees);
        Assertions.assertEquals(employees, departmentService.getAllEmployeesInDepartment(1));
        List<Employee> employees2 = new ArrayList<>();
        Assertions.assertEquals(employees2, departmentService.getAllEmployeesInDepartment(6));
    }

    @Test
    public void testGetAllEmployeesInEachDepartment(){

        Employee employee1 = new Employee("John", "Doe", 1, 1000f);
        Employee employee2 = new Employee("Jane", "Doe", 2, 2000f);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        List<Employee> employeesDepartmentOne = new ArrayList<>();
        List<Employee> employeesDepartmentSecond = new ArrayList<>();
        List<Employee> employeesDepartmentThird = new ArrayList<>();
        List<Employee> employeesDepartmentFourth = new ArrayList<>();
        List<Employee> employeesDepartmentFifth = new ArrayList<>();
        employeesDepartmentOne.add(employee1);
        employeesDepartmentSecond.add(employee2);
        Mockito.when(employeeService.allEmployees()).thenReturn(employees);
        List<List<Employee>> allEmployees = List.of(employeesDepartmentOne, employeesDepartmentSecond, employeesDepartmentThird, employeesDepartmentFourth, employeesDepartmentFifth);
        Assertions.assertEquals(allEmployees, departmentService.getAllEmployeesInDepartment());
    }

}
