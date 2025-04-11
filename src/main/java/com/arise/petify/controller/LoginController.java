package com.arise.petify.controller;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            Model model) throws ExecutionException, InterruptedException {

        Firestore db = FirestoreClient.getFirestore();
        CollectionReference usersRef = db.collection("users");

        // Query Firestore for matching email and password
        ApiFuture<QuerySnapshot> query = usersRef
                .whereEqualTo("email", email)
                .whereEqualTo("password", password)
                .get();

        QuerySnapshot result = query.get();

        if (!result.isEmpty()) {
            return "redirect:/Homepage";  // success → go to index.html
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";  // stay on login page
        }
    }
}
