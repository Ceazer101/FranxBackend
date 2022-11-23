package com.example.franxbackend.services;

import com.example.franxbackend.dtos.BikeRequest;
import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.entities.Bike;
import com.example.franxbackend.repositories.BikeRepository;
import org.springframework.stereotype.Service;

@Service
public class BikeService {

    BikeRepository bikeRepository;

    public  BikeService(BikeRepository bikeRepository){
        this.bikeRepository = bikeRepository;
    }

    public BikeResponse addBike(BikeRequest bikeRequest){
        Bike newBike = BikeRequest.getBikeEntity(bikeRequest);
        newBike = bikeRepository.save(newBike);
        return new BikeResponse(newBike);
    }
}
