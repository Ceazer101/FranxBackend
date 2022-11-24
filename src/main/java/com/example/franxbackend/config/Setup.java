package com.example.franxbackend.config;

import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.entities.Bike;
import com.example.franxbackend.entities.Status;
import com.example.franxbackend.repositories.BikeRepository;
import com.example.franxbackend.services.BikeService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

@Controller
public class Setup implements ApplicationRunner {

    BikeService bikeService;
    BikeRepository bikeRepository;

    public Setup(BikeService bikeService, BikeRepository bikeRepository) {
        this.bikeService = bikeService;
        this.bikeRepository = bikeRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Bike bike = new Bike("123456", "bike", "something", 500, "12-12-12", Status.SOLD);
        Bike bike1 = new Bike("789345", "bmx", "street", 1000, "11-11-11", Status.RESTORED);
        Bike bike2 = new Bike("789945", "bmx", "street", 1000, "11-11-11", Status.SOLD);
        Bike bike3 = new Bike("11111", "bmx", "street", 1000, "12-9-16", Status.SOLD);

        bikeRepository.save(bike1);
        bikeRepository.save(bike);
        bikeRepository.save(bike2);
        bikeRepository.save(bike3);
    }
}
