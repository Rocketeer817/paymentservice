package com.example.paymentservice_final.controllers;

import com.example.paymentservice_final.dtos.InitiatePaymentResponseDto;
import com.example.paymentservice_final.dtos.initiatePaymentRequestDto;
import com.example.paymentservice_final.services.Paymentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private Paymentservice paymentService;

    @PostMapping("/")
    public InitiatePaymentResponseDto initiatePayment(@RequestBody initiatePaymentRequestDto initiatePaymentRequestDto){
        InitiatePaymentResponseDto paymentResponseDto =  new InitiatePaymentResponseDto(){
            {
                setPaymentLink(paymentService.initiatePayment(initiatePaymentRequestDto.getOrderId()));
            }
        };

        return paymentResponseDto;
    }

    @GetMapping("/callback")
    public void paymentCallback(@RequestParam String payment_id){
        System.out.println("Payment callback received for "  + payment_id );

        //Find the payment status from payment gateway and update the order status

    }
}
