package com.example.ficklecalculator.Checkers;

import com.example.ficklecalculator.Exceptions.WrongLoginException;
import com.example.ficklecalculator.Exceptions.WrongPasswordException;

public class UserDataChecker {

    public static boolean checkUserData(String login, String password, String confirmPassword){
        try{
            check(login,password,confirmPassword);
        }catch (WrongLoginException | WrongPasswordException e){
            return false;
        }
        return true;
    }
    public static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!login.matches("^[a-zA-Z0-9_]+$") || login.length() > 20) {
            throw new WrongLoginException("The length of the login cannot exceed 20 characters");
        }
        if ( password.matches("^[a-zA-Z0-9_]+$") || password.length() < 20 || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("The length of the login cannot be less 20 characters or password and confirm password not equal");
        }
    }
}
