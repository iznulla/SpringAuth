package com.auth.simpleauth.processor;

import com.auth.simpleauth.model.User;
import com.auth.simpleauth.service.LoggingManagementService;
import com.auth.simpleauth.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private final UserService userService;
    private final LoggingManagementService loggingManagementService;

    public LoginProcessor(UserService userService, LoggingManagementService loggingManagementService) {
        this.loggingManagementService = loggingManagementService;
        this.userService = userService;
    }


    public boolean login(String name, String password) {
        User user = userService.findByName(name);
        if (user != null && user.getPassword().equals(password)) {
            loggingManagementService.setUsername(name);
            return true;
        } else {
            return false;
        }
    }

    public void logOut() {
        if (loggingManagementService.getUsername() != null) {
            loggingManagementService.setUsername(null);
        }
    }

    public void addUser(User user) {
        userService.addUser(user);
    }
}
