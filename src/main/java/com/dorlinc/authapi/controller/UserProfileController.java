package com.dorlinc.authapi.controller;

import com.dorlinc.authapi.exceptions.AccountNotFoundException;
import com.dorlinc.authapi.model.data.Token;
import com.dorlinc.authapi.model.data.User;
import com.dorlinc.authapi.model.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(path="/authAPI")
public class UserProfileController {

    private UserRepository userRepository;

    @Autowired
    public UserProfileController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/profile")
    @JsonView(User.PROFILE.class)
    public User getUserData( @RequestParam Token token, @RequestParam String userName) throws AccountNotFoundException{
        return userRepository.findById(userName).orElseThrow(AccountNotFoundException::new);
    }
}
