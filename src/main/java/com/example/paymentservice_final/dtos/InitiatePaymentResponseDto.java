package com.example.paymentservice_final.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InitiatePaymentResponseDto {
    private String paymentLink;
}
