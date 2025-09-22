package org.sring.framework.sqch7ex1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/home")
    public String index() {
        return "index.html";
    }
}
