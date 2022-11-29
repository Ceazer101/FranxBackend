package com.example.franxbackend.services;

import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.entities.Bike;
import com.example.franxbackend.entities.Status;
import com.example.franxbackend.repositories.BikeStatisticRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BikeStatisticService {

    BikeStatisticRepository bikeStatisticRepository;

    public BikeStatisticService(BikeStatisticRepository bikeStatisticRepository) {
        this.bikeStatisticRepository = bikeStatisticRepository;
    }

    public List<BikeResponse> getSoldBikesYearly(int year){
        List<Bike> bikesSoldGivenYear = bikeStatisticRepository
                .findBikesByStatus(Status.SOLD);
        bikesSoldGivenYear.removeIf(bike -> year != bike.getSellDate().getYear());

        List<BikeResponse> response = bikesSoldGivenYear.stream().map(bike ->
                new BikeResponse(bike)).collect(Collectors.toList());

        return response;
    }

    public Integer getNumberOfSoldBikesYearly(int year){
        return getSoldBikesYearly(year).size();
    }

    public double totalPriceYearly(int year){
        List<BikeResponse> bikes = getSoldBikesYearly(year);
        double totalPrice = 0;

        for (BikeResponse b: bikes) {
            totalPrice += b.getPrice();
        }
        return totalPrice;
    }






}
