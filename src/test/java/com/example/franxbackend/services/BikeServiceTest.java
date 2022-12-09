package com.example.franxbackend.services;

import com.example.franxbackend.dtos.BikeRequest;
import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.entities.Bike;
import com.example.franxbackend.entities.Status;
import com.example.franxbackend.repositories.BikeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BikeServiceTest {

    public BikeService bikeService;
    public static BikeRepository bikeRepository;

    @BeforeAll
    public static void initTestData(@Autowired BikeRepository bike_repository) {
        bikeRepository = bike_repository;
        bikeRepository.deleteAll();
        Bike bike = new Bike("4053009", "bike", "something", 500, LocalDate.of(2010, Month.OCTOBER, 10), Status.SOLD);
        Bike bike1 = new Bike("789345", "bmx", "street", 1000, LocalDate.of(2011, Month.NOVEMBER, 11), Status.RESTORED);

        bikeRepository.save(bike1);
        bikeRepository.save(bike);
    }

    @BeforeEach
    public void initBikeService() {
        bikeService = new BikeService(bikeRepository);
    }

    @Test
    void addBike() {
        Bike bike = new Bike("123456", "bike", "something", 500, LocalDate.of(2012, Month.DECEMBER, 12), Status.SOLD);
        BikeRequest bikeRequest = new BikeRequest(bike);
        BikeResponse response = bikeService.addBike(bikeRequest);
        assertEquals("123456", response.getFrameNumber());
    }

    @Test
    void getAllBikes() {
        List<BikeResponse> bikeList = bikeService.getAllBikes();

        assertEquals(2, bikeList.size());
    }

    @Test
    void getSingleBike() {
        BikeResponse bikeResponse = bikeService.getSingleBike("4053009");

        assertEquals("4053009", bikeResponse.getFrameNumber());
        assertEquals(500, bikeResponse.getPrice());
        assertEquals(Status.SOLD, bikeResponse.getStatus());
    }

    @Test
    void getSingleBikeByNotExistingFrameNumber() {
        ResponseStatusException bikeResponse1 = Assertions
                .assertThrows(ResponseStatusException.class, () -> bikeService.getSingleBike("I-do-not-Exist"));
        assertEquals(HttpStatus.NOT_FOUND, bikeResponse1.getStatus());
    }

    @Test
    void editBike() {
        BikeRequest bikeRequest = new BikeRequest(new Bike("4053009", "bike", "something", 500, LocalDate.of(2011, Month.NOVEMBER, 11), Status.DISASSEMBLE));
        bikeService.editBike(bikeRequest, "4053009");

        BikeResponse bikeResponse = bikeService.getSingleBike("4053009");
        assertEquals(LocalDate.of(2011, Month.NOVEMBER, 11), bikeResponse.getSellDate());
        assertEquals(Status.DISASSEMBLE, bikeResponse.getStatus());
    }

    @Test
    void deleteBike() {
        bikeRepository.deleteById("4053009");
        assertEquals(1, bikeRepository.count());
    }

}