package com.example.paymentservice_final.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
@Getter
@Setter
public class BaseClass {
    @Id
    private String id;
    @CreationTimestamp
    private String createdAt;
    @UpdateTimestamp
    private String modifiedAt;
}
