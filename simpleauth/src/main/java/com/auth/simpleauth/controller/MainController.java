package com.auth.simpleauth.controller;

import com.auth.simpleauth.aspect.IsLogin;
import com.auth.simpleauth.service.LoggingManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final LoggingManagementService loggingManagementService;

    public MainController(LoggingManagementService loggingManagementService) {
        this.loggingManagementService = loggingManagementService;
    }

    @IsLogin
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("username", loggingManagementService.getUsername());
        return "index.html";
    }
}
