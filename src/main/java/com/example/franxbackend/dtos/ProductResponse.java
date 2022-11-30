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
    private int accountNumber;
    private char taxCode;
    private boolean isArchived;
    private double unitPrice;

    public ProductResponse(Product product) {
        this.productNumber = product.getProductNumber();
        this.productName = product.getProductName();
        this.productDesc = product.getProductDesc();
        this.distributor = product.getDistributor();
        this.accountNumber = product.getAccountNumber();
        this.taxCode = product.getTaxCode();
        this.isArchived = product.isArchived();
        this.unitPrice = product.getUnitPrice();
    }

}
