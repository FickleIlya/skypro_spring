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
    public Float divide(float num1, float num2){
        return num1 / num2;
    }
}
