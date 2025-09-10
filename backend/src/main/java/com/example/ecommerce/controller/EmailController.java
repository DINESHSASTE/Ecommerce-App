 package com.example.ecommerce.controller;

import com.example.ecommerce.dto.EmailRequest;
import com.example.ecommerce.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest request) {
        try {
            emailService.sendEmail(request.getTo(), request.getSubject(), request.getBody());
            return "Email sent successfully to " + request.getTo();
        } catch (Exception e) {
            return "Failed to send email: " + e.getMessage();
        }
    }
}
