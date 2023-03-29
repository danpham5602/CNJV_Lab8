package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/contact")
    public String contactForm() {
        return "contact";
    }

    @PostMapping("/contact")
    public String contactSubmit(@RequestParam String name, @RequestParam String email, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        return "contact-submit";
    }

    @GetMapping("/about")
    @ResponseBody
    public String about() {
        return "About this site";
    }

}