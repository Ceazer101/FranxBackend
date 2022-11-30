package com.example.franxbackend.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Product {

    @Id
    private int productNumber;
    private String productName;
    private String productDesc;
    private String distributor;
    private char taxCode;
    private int numberOfUnits;
    private double unitPrice;

}
