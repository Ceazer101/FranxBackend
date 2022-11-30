package com.example.franxbackend.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productNumber;
    private String productName;
    private String productDesc;
    private String distributor;
    private int accountNumber;
    private char taxCode;
    private boolean isArchived;
    private double unitPrice;

}
