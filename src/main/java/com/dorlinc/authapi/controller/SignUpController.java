package com.dorlinc.authapi.controller;

import com.dorlinc.authapi.exceptions.AccountExistsException;
import com.dorlinc.authapi.model.data.User;
import com.dorlinc.authapi.model.repository.UserRepository;
import com.dorlinc.authapi.password_enc.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/authAPI")
public class SignUpController {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncryptor encryptor;

    @Autowired
    public SignUpController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path="/newUser")
    public @ResponseBody String addNewUser(@RequestParam String userName, @RequestParam String firstName, @RequestParam String lastName
            , @RequestParam String password ) throws AccountExistsException {

        if(userRepository.existsById(userName)){
            throw new AccountExistsException(userName);
        }else {

            User userSignUp = new User();
            userSignUp.setFirstName(firstName);
            userSignUp.setLastName(lastName);
            userSignUp.setUserName(userName);
            encryptor = new PasswordEncryptor();
            String encryptedPassword = encryptor.encrypt(password);
            userSignUp.setUserPassword(encryptedPassword);
            userRepository.save(userSignUp);
            return "Saved";
        }
    }

}
