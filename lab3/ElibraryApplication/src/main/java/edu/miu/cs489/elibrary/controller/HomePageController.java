package edu.miu.cs489.elibrary.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping(value = { "/", "/home", "/elibrary"})
    public String homePage(Model model) {
        return "home/index";
    }
}
