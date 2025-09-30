package org.spring.framework.sqch10ex2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/kumusta")
    public String kumusta(@RequestParam("username") String username) {
        return "Kumusta, " + username;
    }
}
