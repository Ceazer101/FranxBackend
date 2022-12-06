package com.example.franxbackend.dtos;

import com.example.franxbackend.entities.ProductStatistic;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductStatisticsRequest {

    private int productNumber;
    private String productName;
    private int numberOfUnits;
    private double unitPrice;

    public static ProductStatistic getProductStatisticsEntity(ProductRequest productRequest){
        return ProductStatistic.builder()
                .productNumber(productRequest.getProductNumber())
                .productName(productRequest.getProductName())
                .numberOfUnits(productRequest.getNumberOfUnits())
                .unitPrice(productRequest.getUnitPrice())
                .build();
    }

    public ProductStatisticsRequest(ProductStatistic productStatistics) {
        this.productNumber = productStatistics.getProductNumber();
        this.productName = productStatistics.getProductName();
        this.numberOfUnits = productStatistics.getNumberOfUnits();
        this.unitPrice = productStatistics.getUnitPrice();
    }
}
