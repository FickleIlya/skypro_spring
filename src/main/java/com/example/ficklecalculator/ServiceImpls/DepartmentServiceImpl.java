package com.example.ficklecalculator.ServiceImpls;

import com.example.ficklecalculator.Employee.Employee;
import com.example.ficklecalculator.Exceptions.EmployeeNotFoundException;
import com.example.ficklecalculator.Services.DepartmentService;
import com.example.ficklecalculator.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    @Autowired
    public DepartmentServiceImpl(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @Override
    public Employee getEmployeeWithMaxSalary(Integer departmentId){
        Optional<Employee> employeeWithMaxSalary = employeeService.allEmployees().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary));

        return employeeWithMaxSalary.orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee getEmployeeWithMinSalary(Integer departmentId){
        Optional<Employee> employeeWithMaxSalary = employeeService.allEmployees().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary));

        return employeeWithMaxSalary.orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> getAllEmployeesInDepartment(Integer departmentId){

        return employeeService.allEmployees().stream()
                .filter(e -> e.getDepartment() == departmentId).collect(Collectors.toList());
    }

    @Override
    public List<List<Employee>> getAllEmployeesInDepartment(){
        List<Employee> departmentFirst = employeeService.allEmployees().stream()
                .filter(e -> e.getDepartment() == 1).toList();
        List<Employee> departmentSecond = employeeService.allEmployees().stream()
                .filter(e -> e.getDepartment() == 2).toList();
        List<Employee> departmentThird = employeeService.allEmployees().stream()
                .filter(e -> e.getDepartment() == 3).toList();
        List<Employee> departmentFourth = employeeService.allEmployees().stream()
                .filter(e -> e.getDepartment() == 4).toList();
        List<Employee> departmentFifth = employeeService.allEmployees().stream()
                .filter(e -> e.getDepartment() == 5).toList();

        return List.of(departmentFirst, departmentSecond, departmentThird, departmentFourth, departmentFifth);
    }
}
