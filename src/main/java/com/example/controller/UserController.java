package com.example.controller;


import com.example.repository.UserRepository;
import com.example.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SecurityService securityService;

    @RequestMapping("/login")

    public String logIn(@RequestParam(value = "username", required = false) String name, @RequestParam(value = "password", required = false) String password) {
        securityService.logIn();
    }
}
