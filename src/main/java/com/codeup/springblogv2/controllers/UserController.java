package com.codeup.springblogv2.controllers;

import com.codeup.springblogv2.models.User;
import com.codeup.springblogv2.repos.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserRepository userDao;
    private final PasswordEncoder encoder;

    public UserController(UserRepository userDao, PasswordEncoder encoder) {
        this.userDao = userDao;
        this.encoder = encoder;
    }

    @GetMapping("/user/sign-up")
    public String signUpForm(Model model){
        model.addAttribute("signup", new User());
        return "/users/register";
    }

    @PostMapping("/user/sign-up")
    public String signUpSubmit(@ModelAttribute User user){
        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "/users/login";
    }



}
