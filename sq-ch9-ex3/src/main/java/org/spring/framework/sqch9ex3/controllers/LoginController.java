package org.spring.framework.sqch9ex3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.spring.framework.sqch9ex3.processors.LoginProcessor;
import org.spring.framework.sqch9ex3.services.LoggedUserManagementService;

@Controller
public class LoginController {
    private final LoginProcessor loginProcessor;
    private final LoggedUserManagementService loggedUserManagementService;

    @Autowired
    public LoginController(LoginProcessor loginProcessor, LoggedUserManagementService loggedUserManagementService) {
        this.loginProcessor = loginProcessor;
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/")
    public String loginGet() {
        if (loggedUserManagementService.getUsername() != null) {
            return "redirect:/main";
        }
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam String username, @RequestParam String password, Model model) {
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        if (loginProcessor.login()) {
            return "redirect:/main";
        }
        model.addAttribute("message", "Login Failed");
        return "login.html";
    }
}
