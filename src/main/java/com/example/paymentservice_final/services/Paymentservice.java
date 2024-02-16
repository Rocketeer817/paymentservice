package com.example.paymentservice_final.services;

import com.example.paymentservice_final.dtos.InitiatePaymentResponseDto;
import com.example.paymentservice_final.dtos.initiatePaymentRequestDto;
import com.example.paymentservice_final.paymentGateways.PaymentGatewayChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Paymentservice {

    @Autowired
    private PaymentGatewayChooser paymentGatewayChooser;


    public String initiatePayment(String orderId) {
        //Get the order details from order service

        //Dummy details of order
        String email = "rushee2911@gmail.com";
        String phoneNo = "1234567890";
        long amount = 1000;

        // Make a call to payment gateway to generate payment link
        String paymentLink = paymentGatewayChooser.choosePaymentGateway().generatePaymentLink(orderId, email, phoneNo, amount, "http://localhost:8080/payment/callback");
        return paymentLink;
    }
}
