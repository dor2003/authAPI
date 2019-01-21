package com.dorlinc.authapi.token;


import com.dorlinc.authapi.model.data.Token;
import org.apache.commons.codec.DecoderException;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public interface TokenGenerator {
    public Token generateToken() throws DecoderException, UnsupportedEncodingException;
}
