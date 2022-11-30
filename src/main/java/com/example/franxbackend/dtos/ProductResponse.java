package com.example.franxbackend.dtos;

import com.example.franxbackend.entities.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {

    private int productNumber;
    private String productName;
    private String productDesc;
    private String distributor;
    private char taxCode;

    private int numberOfUnits;
    private double unitPrice;

    public ProductResponse(Product product) {
        this.productNumber = product.getProductNumber();
        this.productName = product.getProductName();
        this.productDesc = product.getProductDesc();
        this.distributor = product.getDistributor();
        this.taxCode = product.getTaxCode();
        this.numberOfUnits = product.getNumberOfUnits();
        this.unitPrice = product.getUnitPrice();
    }

}
