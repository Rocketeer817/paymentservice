package com.example.paymentservice_final.paymentGateways;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayChooser {

    private RazorPayPaymentGateway razorPayPaymentGateway;
    private StripePaymentGateway stripePaymentGateway;

    public PaymentGatewayChooser(RazorPayPaymentGateway razorPayPaymentGateway, StripePaymentGateway stripePaymentGateway) {
        this.razorPayPaymentGateway = razorPayPaymentGateway;
        this.stripePaymentGateway = stripePaymentGateway;
    }

    public PaymentGateway choosePaymentGateway() {
        return stripePaymentGateway;
    }
}
