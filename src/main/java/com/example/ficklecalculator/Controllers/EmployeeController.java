package com.example.ficklecalculator.Controllers;

import com.example.ficklecalculator.Services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public String allEmployee(){
        return employeeService.allEmployees();
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam String firstName,@RequestParam String lastName){
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String firstName,@RequestParam String lastName){
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam String firstName,@RequestParam String lastName){
        return employeeService.findEmployee(firstName, lastName);
    }

}
