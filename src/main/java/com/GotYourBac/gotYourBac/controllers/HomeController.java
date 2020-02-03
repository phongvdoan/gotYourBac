package com.GotYourBac.gotYourBac.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //Apparently GetMapping without the route will still give us what we want.
    @GetMapping("/")
    public String gethome(){
        return "home";
    }

    @GetMapping("/balmerpeekinfo")
    public String getBalmerPeekInfo() {
        return "balmerpeek";
    }

    @GetMapping("/error")
    public String getErrorPage(){
        return "error";
    }
}
