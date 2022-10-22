package com.example.ficklecalculator.Controllers;

import com.example.ficklecalculator.Services.CalculatorService;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        return name + " parameter is missing";
    }


    @GetMapping
    public String hello(){
        return calculatorService.hello();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam Float num1, @RequestParam Float num2){
        Float result = calculatorService.plus(num1, num2);
        return num1 + " + " + num2 + " = " + result;
    }

    @GetMapping("/minus")
    public String minus(@RequestParam Float num1, @RequestParam Float num2){
        Float result = calculatorService.minus(num1, num2);
        return num1 + " - " + num2 + " = " + result;
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam Float num1, @RequestParam Float num2){
        Float result = calculatorService.multiply(num1, num2);
        return num1 + " * " + num2 + " = " + result;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam Float num1, @RequestParam Float num2){
        Float result = calculatorService.divide(num1, num2);
        return num1 + " / " + num2 + " = " + result;
    }
}
