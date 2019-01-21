package com.dorlinc.authapi.exceptions;

public class AccountExistsException extends Exception {
    public AccountExistsException(String username) {
        super("Account with username \"" + username + "\" already exists.");
    }
}
