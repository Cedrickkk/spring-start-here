package org.spring.framework.sqch8ex2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(@RequestParam String quote, Model page) {
        page.addAttribute("username", "hula@nm0");
        page.addAttribute("quote", quote);
        return "home.html";
    }
}
