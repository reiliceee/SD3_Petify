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

    @GetMapping("/index")
    public String LandingPage() {
        return "index"; // This points to Homepage.html inside /templates
    }

    @GetMapping("/home")
    public String homepage() {
        return "homepage"; // This points to Homepage.html inside /templates
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

    @GetMapping("/pet-management")
    public String petManagementPage() {
    return "petmanagement"; // no .html, just the filename base
    }

     
    @GetMapping("/Adminprofile")
    public String Adminprofile() {
        return "profile"; // Userprofile.html
    }
    
    @GetMapping("/register")
    public String registerPage() {
    return "register"; // This points to register.html inside /templates
     }

     @GetMapping("/login")
     public String loginPage() {
         return "login"; // This points to login.html inside /templates
     }
  
     @GetMapping("/dashboard")
     public String userDashboard() {
         return "Userdash";
     }
     @GetMapping("/forgot-password")
     public String showForgotPasswordPage() {
    return "Forgotpass";  // This should match your forgot-password.html (without the .html)
    }


    @GetMapping("/medical-services")
    public String showMedicalServicesPage() {
        return "MedicalService";  // This refers to medical-services.html under /templates
    }

    @GetMapping("/grooming-services")
    public String showGroomingServicesPage() {
    return "GroomService";  // points to grooming-services.html in templates
    }

    @GetMapping("/pet-care-services")
    public String showPetCareServicesPage() {
    return "PetCare";  // points to pet-care-services.html
     }

     @GetMapping("/analytics")
    public String showAnalyticsPage() {
        return "Analytics";  // This looks for analytics.html in src/main/resources/templates
    }
    
    @GetMapping("/purchase-pets")
    public String showPurchasePetsPage() {
        return "Purchasepets";  // This looks for purchase-pets.html in src/main/resources/templates
    }

    @GetMapping("/book-appointment")
    public String showBookAppointmentPage() {
        return "Bookservice";  // This should match book-appointment.html in your /templates folder
    }

    @GetMapping("/admin")
    public String AdminPage() {
        return "admin"; 
    }
}

