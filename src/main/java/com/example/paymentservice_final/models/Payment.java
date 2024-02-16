package com.example.paymentservice_final.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment extends BaseClass{
    private String orderId;
    private String paymentLink;
    private String paymentId;
    private PaymentStatusEnum paymentStatus;
}
