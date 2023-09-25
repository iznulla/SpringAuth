package com.auth.simpleauth.controller;

import com.auth.simpleauth.model.User;
import com.auth.simpleauth.processor.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {

    private final LoginProcessor loginProcessor;

    public SignUpController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }
    @GetMapping("/signup")
    public String getSignUp () {
        return "signup.html";
    }

    @PostMapping("/signup")
    public String postSignUp(@RequestParam String username,
                             @RequestParam String password) {
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        loginProcessor.addUser(user);
        return "redirect:/";
    }
}
