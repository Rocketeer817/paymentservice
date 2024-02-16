package com.example.paymentservice_final.paymentGateways;

import com.razorpay.RazorpayException;

public interface PaymentGateway {

    String generatePaymentLink(String orderId, String email, String phoneNo ,long amount);
}
