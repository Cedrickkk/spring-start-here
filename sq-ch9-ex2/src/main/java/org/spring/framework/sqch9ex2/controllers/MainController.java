package org.spring.framework.sqch9ex2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.spring.framework.sqch9ex2.services.LoggedUserManagementService;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;

    @Autowired
    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false) String logout, Model model) {
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }
        if (loggedUserManagementService.getUsername() == null) {
            return "redirect:/";
        }
        model.addAttribute("username", loggedUserManagementService.getUsername());
        return "main.html";
    }
}
