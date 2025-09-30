package org.spring.framework.sqch8ex1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/home")
    public String home(Model page) {
        page.addAttribute("username", "hula@nm0");
        page.addAttribute("quote", "One step at a time.");
        return "home.html";
    }
}
