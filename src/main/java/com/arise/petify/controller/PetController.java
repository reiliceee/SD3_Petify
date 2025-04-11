package com.arise.petify.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;


@Controller
public class PetController {
    @GetMapping("/about")
    public String aboutPage() {
        return "about"; // Looks for about.html inside src/main/resources/templates/
    }
    
    @GetMapping("/services")
    public String servicePage() {
        return "services"; // Looks for about.html inside src/main/resources/templates/
    }


    @GetMapping("/contacts")
    public String contactPage() {
        return "contacts"; // Looks for about.html inside src/main/resources/templates/
    }

    @GetMapping("/")
    public String IndexPage() {
        return "index"; // This points to Homepage.html inside /templates
    }

    @GetMapping("/homepage")
    public String Homepage() {
        return "homepage"; // This points to Homepage.html inside /templates
    }


    @GetMapping("/login")
    public String login() {
        return "login"; // this will look for login.html inside templates/
    }
    
    @GetMapping("/register")
    public String register() {
        return "register"; // this will look for register.html inside templates/
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile"; // this will look for profile.html inside templates/
    }
    @GetMapping("/overview")
    public String adminOverview() {
        return "overview"; // Loads overview.html
    }
     
    @GetMapping("/inbox")
    public String inbox() {
        return "inbox"; // Loads inbox.html
    }




}
