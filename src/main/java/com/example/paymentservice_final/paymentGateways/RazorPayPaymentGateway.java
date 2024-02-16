package com.example.paymentservice_final.paymentGateways;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RazorPayPaymentGateway implements PaymentGateway{

    private RazorpayClient razorpayClient;

    public RazorPayPaymentGateway(RazorpayClient razorpayClient){
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String generatePaymentLink(String orderId, String email, String phoneNo ,long amount,String callback_url) {
        try{
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount",amount);
            paymentLinkRequest.put("currency","INR");
            paymentLinkRequest.put("accept_partial",true);
            paymentLinkRequest.put("first_min_partial_amount",100);
            paymentLinkRequest.put("expire_by",System.currentTimeMillis() + 300000);
            paymentLinkRequest.put("reference_id", orderId);
            paymentLinkRequest.put("description","Payment for policy no #23456");
            JSONObject customer = new JSONObject();
            customer.put("name",phoneNo);
            customer.put("contact","Gaurav Kumar");
            customer.put("email",email);
            paymentLinkRequest.put("customer",customer);
            JSONObject notify = new JSONObject();
            notify.put("sms",true);
            notify.put("email",true);
            paymentLinkRequest.put("notify",notify);
            paymentLinkRequest.put("reminder_enable",true);
            JSONObject notes = new JSONObject();
            notes.put("policy_name","Jeevan Bima");
            paymentLinkRequest.put("notes",notes);
            paymentLinkRequest.put("callback_url",callback_url);
            paymentLinkRequest.put("callback_method","get");

            PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);

            return payment.get("short_url").toString();
        }
        catch (RazorpayException e){
            e.printStackTrace();
            return "fuck";
        }


    }
}
