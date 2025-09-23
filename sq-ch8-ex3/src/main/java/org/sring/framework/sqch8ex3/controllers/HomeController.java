package org.sring.framework.sqch8ex3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(@RequestParam(required = false) String username,
                       @RequestParam(required = false) String quote,
                       Model page) {
        page.addAttribute("username", username);
        page.addAttribute("quote", quote);
        return "home.html";
    }
}
