package com.example.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @PostMapping("/charge")
    public ResponseEntity<?> charge(@RequestBody Object paymentRequest){
        // Simulate payment processing
        return ResponseEntity.ok("Payment successful");
    }
}
