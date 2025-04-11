package com.arise.petify.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arise.petify.service.EmailService;

@RestController
@RequestMapping("/api/otp")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String otp = emailService.sendOtpEmail(email);

        // TODO: Store OTP securely in a database, cache, or session for validation
        return ResponseEntity.ok(otp); // Don’t return OTP in production!
    }
}
