package com.example.franxbackend.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BikeStatisticResponse {

    List<BikeResponse> bikesSold;
    int NumberOfSoldBikesYearly;
    double totalPriceYearly;
    List<Integer> quarterlyNumbers;
    List<Double> totalPriceQuarterly;

}
