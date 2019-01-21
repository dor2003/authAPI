package com.dorlinc.authapi.exceptions;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException() {
        super("This account doesn't exist.");
    }
}
