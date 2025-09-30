package org.spring.framework.sqch9ex1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.spring.framework.sqch9ex1.processors.LoginProcessor;

import java.util.logging.Logger;

@Controller
public class LoginController {
    private static final Logger logger = Logger.getLogger(LoginController.class.getName());
    private final LoginProcessor loginProcessor;

    @Autowired
    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam String username, @RequestParam String password, Model model) {
        // new instance of LoginProcessor is created for each new HTTP request and disposed once the request is complete
        logger.info("Handling login request with processor ID: {}" + loginProcessor.getId());

        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean loggedIn = loginProcessor.login();
        model.addAttribute("message", loggedIn ? "You are now logged in." : "Login failed");
        return "login.html";
    }
}
