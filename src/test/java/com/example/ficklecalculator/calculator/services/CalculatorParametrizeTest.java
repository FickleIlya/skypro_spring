package com.example.ficklecalculator.calculator.services;

import com.example.ficklecalculator.ServiceImpls.CalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorParametrizeTest {

    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    @ParameterizedTest
    @MethodSource("plusProvider")
    public void testPlus(Float num1, Float num2, Float expected){
        Float result = calculatorService.plus(num1, num2);
        Assertions.assertEquals(result, expected);
    }

    @ParameterizedTest
    @MethodSource("minusProvider")
    public void testMinus(Float num1, Float num2, Float expected){
        Float result = calculatorService.minus(num1, num2);
        Assertions.assertEquals(result, expected);
    }

    @ParameterizedTest
    @MethodSource("multiplyProvider")
    public void testMultiply(Float num1, Float num2, Float expected){
        Float result = calculatorService.multiply(num1, num2);
        Assertions.assertEquals(result, expected);
    }

    @ParameterizedTest
    @MethodSource("divideProvider")
    public void testDivide(Float num1, Float num2, Float expected){
        Float result = calculatorService.divide(num1, num2);
        Assertions.assertEquals(result, expected);
    }
    public static Stream<Arguments> plusProvider() {
        return Stream.of(
                Arguments.of(1f, 2f, 3f),
                Arguments.of(1f, -2f, -1f)
        );
    }

    public static Stream<Arguments> minusProvider() {
        return Stream.of(
                Arguments.of(1f, 2f, -1f),
                Arguments.of(1f, -2f, 3f)
        );
    }

    public static Stream<Arguments> multiplyProvider() {
        return Stream.of(
                Arguments.of(1f, 2f, 2f),
                Arguments.of(1f, -2f, -2f)
        );
    }

    public static Stream<Arguments> divideProvider() {
        return Stream.of(
                Arguments.of(1f, 2f, 0.5f),
                Arguments.of(1f, -2f, -0.5f)
        );
    }
}
