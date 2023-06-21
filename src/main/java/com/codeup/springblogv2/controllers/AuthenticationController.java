package com.codeup.springblogv2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String showLoginForm(){
        return "/users/login";
    }


//    @PostMapping("/logout")
//    public String logout(){
//
//
//        return "redirect:/login";
//    }
}
