package com.dorlinc.authapi.token;

import com.dorlinc.authapi.model.data.Token;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class SHA256TokenGenerator implements TokenGenerator {

    @Override
    public Token generateToken(String userName) {

        String token = DigestUtils.sha256Hex(userName);

        return new Token(token);
    }
}
