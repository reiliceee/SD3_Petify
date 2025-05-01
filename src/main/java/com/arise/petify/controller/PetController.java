package com.arise.petify.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PetController {
  
    @GetMapping("/about")
    public String aboutPage() {
        return "about"; // about.html
    }

    @GetMapping("/services")
    public String servicePage() {
        return "services"; // services.html
    }

    @GetMapping("/contacts")
    public String contactPage() {
        return "contacts"; // Looks for about.html inside src/main/resources/templates/
    }


    @GetMapping("/")
    public String homePage() {
        return "Homepage"; // This points to Homepage.html inside /templates
    }

    @GetMapping("/profile")
    public String profile() {
        return "Userprofile"; // Userprofile.html
    }

    // 🆕 Added routes for new features

    @GetMapping("/shop")
    public String shopPage() {
        return "PetProducts"; // shop.html
    }

    @GetMapping("/appointments")
    public String appointmentsPage() {
        return "Appointments"; // appointments.html
    }

    @GetMapping("/lost-found")
    public String lostFoundPage() {
        return "LostFound"; // lost-found.html
    }

    @GetMapping("/community")
    public String communityPage() {
        return "Community"; // community.html
    }

    @GetMapping("/feedback")
    public String feedbackPage() {
        return "RatingFeedback"; // feedback.html
    }
    @GetMapping("/customerservice")
    public String CustomerServicePage() {
        return "CustomerService"; // CustomerService.html
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
