package com.dorlinc.authapi.controller;

import com.dorlinc.authapi.exceptions.AccountNotFoundException;
import com.dorlinc.authapi.exceptions.IncorrectPasswordException;
import com.dorlinc.authapi.model.data.Token;
import com.dorlinc.authapi.model.repository.TokenRepository;
import com.dorlinc.authapi.model.repository.UserRepository;
import com.dorlinc.authapi.password_enc.PasswordEncryptor;
import com.dorlinc.authapi.token.SHA256TokenGenerator;
import com.dorlinc.authapi.token.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/authAPI")
public class LoginController {


    private SHA256TokenGenerator generator;
    private UserRepository userRepository;
    private TokenRepository tokenRepository;
    private PasswordEncryptor encryptor;

    @Autowired
    public LoginController(SHA256TokenGenerator generator, UserRepository userRepository, TokenRepository tokenRepository, PasswordEncryptor encryptor) {
        this.generator = generator;
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.encryptor = encryptor;
    }

    @GetMapping(path="/login")
    public @ResponseBody String getToken(@RequestParam String userName, @RequestParam String userPassword) throws IncorrectPasswordException {
        String password = userRepository.findById(userName)
                .orElseThrow(AccountNotFoundException::new)
                .getUserPassword();

        String checkPassword  = encryptor.encrypt(userPassword);

        if (!password.equals(checkPassword)){
            throw new IncorrectPasswordException();
        }else{
            Token token = tokenRepository.save(generator.generateToken(userName));
            userRepository.findById(userName)
                    .orElseThrow(AccountNotFoundException::new)
                    .setToken(token);
            return "You successfully logged in.";
        }
    }
}
