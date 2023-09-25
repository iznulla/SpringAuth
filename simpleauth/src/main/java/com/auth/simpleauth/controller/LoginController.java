package com.auth.simpleauth.controller;

import com.auth.simpleauth.processor.LoginProcessor;
import com.auth.simpleauth.service.LoggingManagementService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/")
    public String postLogin(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {
        boolean loginId = loginProcessor.login(username, password);

        if (loginId) {
            return "redirect:/index";
        }
        return "login.html";
    }
    @GetMapping("/logout")
    public String logOut() {
        loginProcessor.logOut();
        return "login.html";
    }

}


