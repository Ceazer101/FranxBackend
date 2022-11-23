package com.example.franxbackend.services;

import com.example.franxbackend.dtos.BikeRequest;
import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.entities.Bike;
import com.example.franxbackend.entities.Status;
import com.example.franxbackend.repositories.BikeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class BikeServiceTest {

    public BikeService bikeService;
    public static BikeRepository bikeRepository;

    @BeforeAll
    public static void initTestData(@Autowired BikeRepository bike_repository){
        bikeRepository = bike_repository;
        bikeRepository.deleteAll();
    }

    @BeforeEach
    public void initBikeService(){
        bikeService = new BikeService(bikeRepository);
    }

    @Test
    void addBike() {
        Bike bike = new Bike("123456", "bike", "something", 500, "12-12-12", Status.SOLD);
        BikeRequest bikeRequest = new BikeRequest(bike);
        BikeResponse response = bikeService.addBike(bikeRequest);
        assertEquals("123456", response.getFrameNumber());
    }
}