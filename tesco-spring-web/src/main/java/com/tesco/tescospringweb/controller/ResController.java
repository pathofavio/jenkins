package com.tesco.tescospringweb.controller;

import model.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/mainapp")
public class ResController {

    //@RequestMapping(path = "/login", method = RequestMethod.GET)
    @GetMapping("/login")
    //@ResponseBody
    public String loginPage(){
        return "login";
    }

    //@RequestMapping(path = "/registration", method = RequestMethod.GET)
    @GetMapping("/registration")
    //@ResponseBody
    public String registrationPage(){
        return "registration";
    }

}
