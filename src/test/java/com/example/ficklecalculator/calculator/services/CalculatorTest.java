package com.example.ficklecalculator.calculator.services;

import com.example.ficklecalculator.ServiceImpls.CalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    @Test
    public void testPlus(){
        Float result1 = calculatorService.plus(1f, 2f);
        Float result2 = calculatorService.plus(1f, -2f);
        Assertions.assertEquals(result1, 3f);
        Assertions.assertEquals(result2, -1f);
    }

    @Test
    public void testMinus(){
        Float result1 = calculatorService.minus(1f, 2f);
        Float result2 = calculatorService.minus(1f, -2f);
        Assertions.assertEquals(result1, -1f);
        Assertions.assertEquals(result2, 3f);
    }

    @Test
    public void testMultiply(){
        Float result1 = calculatorService.multiply(1f, 2f);
        Float result2 = calculatorService.multiply(1f, -2f);
        Assertions.assertEquals(result1, 2f);
        Assertions.assertEquals(result2, -2f);
    }

    @Test
    public void testDivide(){
        Float result1 = calculatorService.divide(1f, 2f);
        Float result2 = calculatorService.divide(1f, -2f);
        Assertions.assertEquals(result1, 0.5f);
        Assertions.assertEquals(result2, -0.5f);
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(1f, 0f));
    }
}
