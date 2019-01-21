package com.dorlinc.authapi.exceptions;

public class IncorrectPasswordException extends Exception{
    public IncorrectPasswordException() {
        super("The password is incorrect");
    }
}
