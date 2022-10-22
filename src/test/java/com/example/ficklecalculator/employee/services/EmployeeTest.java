package com.example.ficklecalculator.employee.services;

import com.example.ficklecalculator.Exceptions.EmployeeAlreadyAddedException;
import com.example.ficklecalculator.Exceptions.EmployeeNotFoundException;
import com.example.ficklecalculator.ServiceImpls.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Test
    public void testAddEmployee(){
        employeeService.addEmployee("John", "Doe", 1, 1000f);
        Assertions.assertEquals(1, employeeService.allEmployees().size());
        employeeService.addEmployee("Jane", "Doe", 1, 1000f);
        Assertions.assertEquals(2, employeeService.allEmployees().size());
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.addEmployee("John", "Doe", 1, 1000f));
    }

    @Test
    public void testRemoveEmployee(){
        employeeService.addEmployee("John", "Doe", 1, 1000f);
        employeeService.addEmployee("Jane", "Doe", 1, 1000f);
        Assertions.assertEquals(2, employeeService.allEmployees().size());
        employeeService.removeEmployee("John", "Doe");
        Assertions.assertEquals(1, employeeService.allEmployees().size());
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.removeEmployee("John", "Doe"));
    }

    @Test
    public void testFindEmployee(){
        employeeService.addEmployee("John", "Doe", 1, 1000f);
        employeeService.addEmployee("Jane", "Doe", 1, 1000f);
        Assertions.assertEquals(2, employeeService.allEmployees().size());
        Assertions.assertEquals("John", employeeService.findEmployee("John", "Doe").getFirstName());
        Assertions.assertEquals("Jane", employeeService.findEmployee("Jane", "Doe").getFirstName());
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.findEmployee("John", "Doe2"));
    }

}
