package com.example.ficklecalculator.Controllers;

import com.example.ficklecalculator.Employee.Employee;
import com.example.ficklecalculator.Services.DepartmentService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {this.departmentService = departmentService;}

    @GetMapping("/max-salary")
    public String getMaxSalary(@RequestParam Integer departmentId){
        Employee employee = departmentService.getEmployeeWithMaxSalary(departmentId);
        return new Gson().toJson(employee);
    }

    @GetMapping("/min-salary")
    public String getMinSalary(@RequestParam Integer departmentId){
        Employee employee = departmentService.getEmployeeWithMinSalary(departmentId);
        return new Gson().toJson(employee);
    }

    @GetMapping("/all")
    public String getAllEmployeesInDepartment(@RequestParam(required = false) Integer departmentId){
        if(departmentId != null) {
            List<Employee> employees = departmentService.getAllEmployeesInDepartment(departmentId);
            return new Gson().toJson(employees);
        }
        List<List<Employee>> employees = departmentService.getAllEmployeesInDepartment();
        return new Gson().toJson(employees);
    }
}
