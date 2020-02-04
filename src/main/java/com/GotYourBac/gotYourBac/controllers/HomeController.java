package com.GotYourBac.gotYourBac.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(Principal p){
        if(p !=null){
            System.out.println(p.getName());
        }else {
            System.out.println("null");
        }

        return "home";
    }
}
