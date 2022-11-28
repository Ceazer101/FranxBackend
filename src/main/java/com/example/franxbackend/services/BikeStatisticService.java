package com.example.franxbackend.services;

import com.example.franxbackend.dtos.BikeRequest;
import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.entities.Bike;
import com.example.franxbackend.entities.Status;
import com.example.franxbackend.repositories.BikeStatisticRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BikeStatisticService {

    BikeStatisticRepository bikeStatisticRepository;


    public BikeStatisticService(BikeStatisticRepository bikeStatisticRepository) {
        this.bikeStatisticRepository = bikeStatisticRepository;
    }

    public List<BikeResponse> getSoldBikes(){
        List<Bike> bikes = bikeStatisticRepository.findBikeByStatus(Status.SOLD);

        List<BikeResponse> soldBikes = bikes.stream().map(bike -> new BikeResponse(bike)).toList();

        return soldBikes;
    }

    public int numberOfSoldBikes(){
        List<BikeResponse> bikes = getSoldBikes();
        return bikes.size();
    }

    public double totalPriceOfSoldBikes(){
        List<BikeResponse> bikes = getSoldBikes();
        double totalPrice = 0;

        for (BikeResponse b: bikes) {
            totalPrice += b.getPrice();
        }
        return totalPrice;
    }



}
