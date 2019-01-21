package com.dorlinc.authapi.token;

import com.dorlinc.authapi.model.data.Token;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Random;

@Service
public class SHA256TokenGenerator implements TokenGenerator {

    @Override
    public Token generateToken() throws DecoderException, UnsupportedEncodingException {

        byte[] array = new byte[10];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        String hexToken = DigestUtils.sha256Hex(generatedString);

          StringBuilder token = new StringBuilder("");

          for(int i = 0; i < hexToken.length(); i+=2){
              String str = hexToken.substring(i, i + 2);
              token.append((char) Integer.parseInt(str, 16));
          }

        return new Token(token.toString());
    }
}
