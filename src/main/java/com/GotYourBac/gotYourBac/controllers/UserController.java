package com.GotYourBac.gotYourBac.controllers;

import com.GotYourBac.gotYourBac.models.ApplicationUser;
import com.GotYourBac.gotYourBac.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String getRegistration(){
        return "registration";
    }

}
