package org.sring.framework.sqch8ex4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/home/{quote}")
    public String home(@PathVariable String quote, Model page) {
        page.addAttribute("username", "hula@nm0");
        page.addAttribute("quote", quote);
        return "home.html";
    }
}
