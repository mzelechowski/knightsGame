package com.malarska.knightsgame.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String hello() {
        return "helloworld.html";
    }

    @GetMapping("/trawa")
    public String rosliny() {
        return "trawa.html";
    }
}
