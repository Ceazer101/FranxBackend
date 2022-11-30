package com.example.franxbackend.services;

import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.dtos.BikeStatisticResponse;
import com.example.franxbackend.entities.Bike;
import com.example.franxbackend.entities.Status;
import com.example.franxbackend.repositories.BikeStatisticRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BikeStatisticServiceTest {

    public static BikeStatisticService bikeStatisticService;
    public static BikeStatisticRepository bikeStatisticRepository;

    @BeforeAll
    public static void setup(@Autowired BikeStatisticRepository bsr){
        bikeStatisticRepository = bsr;

        bikeStatisticRepository.deleteAll();
        Bike bike = new Bike("4053009", "bike", "something", 500, LocalDate.of(2022, Month.OCTOBER, 10), Status.SOLD);
        Bike bike1 = new Bike("789345", "bmx", "street", 1000, LocalDate.of(2011, Month.NOVEMBER, 11), Status.RESTORED);

        bikeStatisticRepository.save(bike);
        bikeStatisticRepository.save(bike1);
    }

    @BeforeEach
    public void setBikeStatisticService(){
        bikeStatisticService = new BikeStatisticService(bikeStatisticRepository);
    }

   /* @Test
    void getSoldBikesYearly() {
        List<Bike> bikes = bikeStatisticRepository.findBikesByStatus(Status.SOLD);
        List<BikeResponse> actualSoldBikes = bikeStatisticService.getSoldBikesYearly(2022);


        List<BikeResponse> soldBikes = bikes.stream().map(bike ->
                new BikeResponse(bike)).collect(Collectors.toList());

        assertIterableEquals(soldBikes, actualSoldBikes);
    }*/

    @Test
    void getNumberOfSoldBikesYearly() {
        List<BikeResponse> soldBikes = bikeStatisticService.getSoldBikesYearly(2022);
        assertEquals(1, soldBikes.size());
    }

    @Test
    void totalPriceYearly() {
        List<BikeResponse> soldBikes = bikeStatisticService.getSoldBikesYearly(2022);
        int totalPrice = 0;
        for (BikeResponse b : soldBikes){
            totalPrice += b.getPrice();
        }
        assertEquals(500, totalPrice);
    }


}