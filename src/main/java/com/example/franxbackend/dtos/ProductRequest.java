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
    private char taxCode;

    private int numberOfUnits;
    private double unitPrice;


    public static Product getProductEntity(ProductRequest productRequest){
        return Product.builder()
                .productNumber(productRequest.productNumber)
                .productName(productRequest.productName)
                .productDesc(productRequest.productDesc)
                .distributor(productRequest.distributor)
                .taxCode(productRequest.taxCode)
                .unitPrice(productRequest.unitPrice)
                .numberOfUnits(productRequest.numberOfUnits)
                .build();
    }

    public ProductRequest(Product product) {
        this.productNumber = product.getProductNumber();
        this.productName = product.getProductName();
        this.productDesc = product.getProductDesc();
        this.distributor = product.getDistributor();
        this.taxCode = product.getTaxCode();
        this.numberOfUnits = product.getNumberOfUnits();
        this.unitPrice = product.getUnitPrice();
    }



}
