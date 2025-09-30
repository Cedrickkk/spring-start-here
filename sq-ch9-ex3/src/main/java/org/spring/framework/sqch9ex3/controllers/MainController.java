package org.spring.framework.sqch9ex3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.spring.framework.sqch9ex3.services.LoggedUserManagementService;
import org.spring.framework.sqch9ex3.services.LoginCountService;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    @Autowired
    public MainController(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
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
        model.addAttribute("loginCount", loginCountService.getCount());
        return "main.html";
    }
}
