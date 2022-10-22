package com.example.ficklecalculator.ServiceImpls;

import com.example.ficklecalculator.Services.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String hello(){
        return "Добро пожаловать в калькулятор";
    }

    @Override
    public Float plus(float num1, float num2){
        return num1 + num2;
    }

    @Override
    public Float minus(float num1, float num2){
        return num1 - num2;
    }

    @Override
    public Float multiply(float num1, float num2){
        return num1 * num2;
    }

    @Override
    public Float divide(float num1, float num2) throws IllegalArgumentException{
        if (num2 == 0){
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return num1 / num2;
    }
}
