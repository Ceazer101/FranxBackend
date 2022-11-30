package com.example.franxbackend.dtos;

import com.example.franxbackend.entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequest {

    private int productNumber;
    private String productName;
    private String productDesc;
    private String distributor;
    private int accountNumber;
    private char taxCode;
    private boolean isArchived;
    private double unitPrice;


    public static Product getProductEntity(ProductRequest productRequest){
        return Product.builder()
                .productNumber(productRequest.productNumber)
                .productName(productRequest.productName)
                .productDesc(productRequest.productDesc)
                .distributor(productRequest.distributor)
                .accountNumber(productRequest.accountNumber)
                .taxCode(productRequest.taxCode)
                .isArchived(productRequest.isArchived)
                .unitPrice(productRequest.unitPrice)
                .build();
    }

    public ProductRequest(Product product) {
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
