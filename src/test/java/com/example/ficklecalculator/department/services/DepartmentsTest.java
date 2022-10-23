package com.example.ficklecalculator.department.services;

import com.example.ficklecalculator.Employee.Employee;
import com.example.ficklecalculator.Exceptions.EmployeeNotFoundException;
import com.example.ficklecalculator.ServiceImpls.DepartmentServiceImpl;
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

import static com.example.ficklecalculator.department.constants.DepartmentConstants.*;


@ExtendWith(MockitoExtension.class)
public class DepartmentsTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;


    @Test
    public void testGetEmployeeWithMaxSalary(){
        Mockito.when(employeeService.allEmployees()).thenReturn(employees);
        Assertions.assertEquals(employee2, departmentService.getEmployeeWithMaxSalary(employee2.getDepartment()));
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> departmentService.getEmployeeWithMinSalary(6));
    }

    @Test
    public void testGetEmployeeWithMinSalary(){
        Mockito.when(employeeService.allEmployees()).thenReturn(employees);
        Assertions.assertEquals(employee1, departmentService.getEmployeeWithMinSalary(employee1.getDepartment()));
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> departmentService.getEmployeeWithMinSalary(6));
    }

    @Test
    public void testGetAllEmployeesInDepartment(){
        Mockito.when(employeeService.allEmployees()).thenReturn(employees);
        List<Employee> employeesInDepartmentOne = employeeService.allEmployees().stream().filter(employee -> employee.getDepartment() == 1).toList();
        Assertions.assertEquals(employeesInDepartmentOne, departmentService.getAllEmployeesInDepartment(1));
        Assertions.assertEquals(new ArrayList<>(), departmentService.getAllEmployeesInDepartment(6));
    }

    @Test
    public void testGetAllEmployeesInEachDepartment(){
        Mockito.when(employeeService.allEmployees()).thenReturn(employees);

        List<Employee> employeesDepartmentOne = employeeService.allEmployees().stream()
                .filter(employee -> employee.getDepartment() == 1)
                .toList();
        List<Employee> employeesDepartmentSecond = employeeService.allEmployees().stream()
                .filter(employee -> employee.getDepartment() == 2)
                .toList();
        List<Employee> employeesDepartmentThird = employeeService.allEmployees().stream()
                .filter(employee -> employee.getDepartment() == 3)
                .toList();
        List<Employee> employeesDepartmentFourth = employeeService.allEmployees().stream()
                .filter(employee -> employee.getDepartment() == 4)
                .toList();
        List<Employee> employeesDepartmentFifth = employeeService.allEmployees().stream()
                .filter(employee -> employee.getDepartment() == 5)
                .toList();

        List<List<Employee>> allEmployees = List.of(employeesDepartmentOne, employeesDepartmentSecond, employeesDepartmentThird, employeesDepartmentFourth, employeesDepartmentFifth);
        Assertions.assertEquals(allEmployees, departmentService.getAllEmployeesInDepartment());
    }

}
