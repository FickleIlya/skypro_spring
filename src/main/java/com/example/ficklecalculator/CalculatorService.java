package com.example.ficklecalculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public String hello(){
        return "Добро пожаловать в калькулятор";
    }

    public float plus(float num1, float num2){
        return num1 + num2;
    }

    public float minus(float num1, float num2){
        return num1 - num2;
    }

    public float multiply(float num1, float num2){
        return num1 * num2;
    }

    public float divide(float num1, float num2){
        if (num2 == 0){
            return 0;
        }
        return num1 / num2;
    }
}
