package com.example.ficklecalculator.Controllers;

import com.example.ficklecalculator.Checkers.UserDataChecker;
import com.example.ficklecalculator.Services.EmployeeService;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
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
        UserDataChecker.checkIsAlpha(firstName, lastName);
        return new Gson().toJson(employeeService.addEmployee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), department, salary));
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String firstName,@RequestParam String lastName){
        UserDataChecker.checkIsAlpha(firstName, lastName);
        return employeeService.removeEmployee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName));
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam String firstName,@RequestParam String lastName){
        UserDataChecker.checkIsAlpha(firstName, lastName);
        return new Gson().toJson(employeeService.findEmployee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName)));
    }

}
