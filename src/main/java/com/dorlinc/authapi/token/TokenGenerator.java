package com.dorlinc.authapi.token;


import com.dorlinc.authapi.model.data.Token;
import org.springframework.stereotype.Component;

@Component
public interface TokenGenerator {
    public Token generateToken(String userName);
}
