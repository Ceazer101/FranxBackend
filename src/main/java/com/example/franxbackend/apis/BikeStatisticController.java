package com.example.franxbackend.apis;

import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.dtos.BikeStatisticResponse;
import com.example.franxbackend.services.BikeStatisticService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/statistics-bike")
@CrossOrigin
public class BikeStatisticController {

    BikeStatisticService bikeStatisticService;

    public BikeStatisticController(BikeStatisticService bikeStatisticService) {
        this.bikeStatisticService = bikeStatisticService;
    }

    @GetMapping
    public BikeStatisticResponse getSoldBikes(){
        List<BikeResponse> soldBikes = bikeStatisticService.getSoldBikes();
        int numberOfSoldBikes = bikeStatisticService.numberOfSoldBikes();
        double totalPrice = bikeStatisticService.totalPriceOfSoldBikes();
        return new BikeStatisticResponse(soldBikes, numberOfSoldBikes, totalPrice);
    }





}
