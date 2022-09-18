package com.example.ficklecalculator.Exceptions;

public class WrongLoginException extends Exception{
    public WrongLoginException(String message) {
        super(message);
    }
}
