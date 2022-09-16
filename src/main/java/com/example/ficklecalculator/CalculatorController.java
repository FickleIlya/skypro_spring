package com.example.ficklecalculator;

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


    @GetMapping("")
    public String hello(){
        return calculatorService.hello();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") float num1, @RequestParam("num2") float num2){
        float result = calculatorService.plus(num1, num2);
        return num1 + " + " + num2 + " = " + result;
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") float num1, @RequestParam("num2") float num2){
        float result = calculatorService.minus(num1, num2);
        return num1 + " - " + num2 + " = " + result;
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") float num1, @RequestParam("num2") float num2){
        float result = calculatorService.multiply(num1, num2);
        return num1 + " * " + num2 + " = " + result;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") float num1, @RequestParam("num2") float num2){
        float result = calculatorService.divide(num1, num2);
        if (result == 0){
            return "На ноль делить нельзя";
        }
        return num1 + " / " + num2 + " = " + result;
    }
}
