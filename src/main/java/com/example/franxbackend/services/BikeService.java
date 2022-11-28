package com.example.franxbackend.services;

import com.example.franxbackend.dtos.BikeRequest;
import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.entities.Bike;
import com.example.franxbackend.repositories.BikeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

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


    public List<BikeResponse> getAllBikes(){
        List<Bike> bikes = bikeRepository.findAll();
        List<BikeResponse> response = bikes.stream().map(bike ->
                new BikeResponse(bike)).collect(Collectors.toList());

        return response;
    }

    public BikeResponse getSingleBike(String frameNumber){
         Bike bike = bikeRepository.findById(frameNumber).orElseThrow(()->
                 new ResponseStatusException(HttpStatus.NOT_FOUND,"Bike with this frame number does not exist"));
         BikeResponse bikeResponse = new BikeResponse(bike);
         return bikeResponse;
    }


}
