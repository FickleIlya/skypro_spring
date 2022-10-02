package com.example.ficklecalculator.Controllers;

import com.example.ficklecalculator.Services.EmployeeService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public String allEmployee(){
        return new Gson().toJson(employeeService.allEmployees());
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer department, @RequestParam Float salary){
        return new Gson().toJson(employeeService.addEmployee(firstName, lastName, department, salary));
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String firstName,@RequestParam String lastName){
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam String firstName,@RequestParam String lastName){
        return new Gson().toJson(employeeService.findEmployee(firstName, lastName));
    }

}
