package com.GotYourBac.gotYourBac.controllers;

import com.GotYourBac.gotYourBac.models.ApplicationUser;
import com.GotYourBac.gotYourBac.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

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

    @PostMapping("/registration")
    public RedirectView createNewUser(String username, String password, String firstName, String lastName, String gender, double height, float weight) {
        ApplicationUser newUser = new ApplicationUser(username, passwordEncoder.encode(password), firstName, lastName, gender, height, weight);
        applicationUserRepository.save(newUser);
        return new RedirectView("/");
    }
}
