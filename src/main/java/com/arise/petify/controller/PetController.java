package com.arise.petify.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;


@Controller
public class PetController {

    @GetMapping("/")
    public String profile() {
        return "profile"; // this will look for profile.html inside templates/
    }
}
