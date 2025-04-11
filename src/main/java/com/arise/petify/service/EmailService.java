package com.arise.petify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public String sendOtpEmail(String toEmail) {
        String otp = String.format("%06d", new Random().nextInt(999999));

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Your Petify OTP Code");
        message.setText("Your OTP code is: " + otp + "\nIt is valid for 5 minutes.");

        mailSender.send(message);
        return otp; // Store this for later verification
    }
}