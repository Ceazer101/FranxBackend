package com.example.franxbackend.dtos;

import com.example.franxbackend.entities.ProductStatistic;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductStatisticsResponse {

    private int productNumber;
    private String productName;
    private int numberOfUnits;
    private double unitPrice;

    private LocalDateTime dateSold;

    public ProductStatisticsResponse(ProductStatistic productStatistic) {
        this.productNumber = productStatistic.getProductNumber();
        this.productName = productStatistic.getProductName();
        this.numberOfUnits = productStatistic.getNumberOfUnits();
        this.unitPrice = productStatistic.getUnitPrice();
        this.dateSold = productStatistic.getDateSold();
    }
}
