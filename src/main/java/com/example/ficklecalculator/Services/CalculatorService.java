package com.example.ficklecalculator.Services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public String hello(){
        return "Добро пожаловать в калькулятор";
    }

    public Float plus(float num1, float num2){
        return num1 + num2;
    }

    public Float minus(float num1, float num2){
        return num1 - num2;
    }

    public Float multiply(float num1, float num2){
        return num1 * num2;
    }

    public Float divide(float num1, float num2){
        return num1 / num2;
    }
}
