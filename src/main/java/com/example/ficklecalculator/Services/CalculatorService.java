package com.example.ficklecalculator.Services;

public interface CalculatorService {
    String hello();

    Float plus(float num1, float num2);

    Float minus(float num1, float num2);

    Float multiply(float num1, float num2);

    Float divide(float num1, float num2) throws IllegalArgumentException;
}
