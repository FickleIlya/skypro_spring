package com.example.ficklecalculator.Exceptions;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(String message) {
        super(message);
    }
}
