package com.GotYourBac.gotYourBac.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//https://www.baeldung.com/spring-boot-custom-error-page
@Controller
public class appErrorController implements ErrorController {

    //TODO: add some logging later
    @GetMapping("/error")
    public String handleError() {
        //do something like logging
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
