package com.arise.petify.controller;

import com.arise.petify.model.User;
import com.arise.petify.service.FirebaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private FirebaseUserService firebaseUserService;

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        String result = firebaseUserService.saveUser(user);
        return ResponseEntity.ok(result);
    }
}
