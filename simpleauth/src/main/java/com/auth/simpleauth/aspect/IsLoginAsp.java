package com.auth.simpleauth.aspect;

import com.auth.simpleauth.service.LoggingManagementService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class IsLoginAsp {
    private final LoggingManagementService loggingManagementService;

    public IsLoginAsp(LoggingManagementService loggingManagementService) {
        this.loggingManagementService = loggingManagementService;
    }

    @Around("@annotation(IsLogin)")
    public Object auth(ProceedingJoinPoint joinPoint) throws Throwable {
        String username = loggingManagementService.getUsername();
        if (username == null) {
            return "redirect:/";
        } else {
            return joinPoint.proceed();
        }
    }
}
