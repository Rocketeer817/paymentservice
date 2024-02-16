package com.example.paymentservice_final.controllers;

import jdk.jfr.Event;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    @PostMapping("/stripe")
    public void stripeWebhook(Event event){
        System.out.println("Stripe Webhook received" + event);
    }
}
