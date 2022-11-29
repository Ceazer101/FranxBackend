package com.example.franxbackend.apis;

import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.dtos.BikeStatisticResponse;
import com.example.franxbackend.entities.Bike;
import com.example.franxbackend.services.BikeStatisticService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("api/statistics-bike")
@CrossOrigin
public class BikeStatisticController {

    BikeStatisticService bikeStatisticService;

    public BikeStatisticController(BikeStatisticService bikeStatisticService) {
        this.bikeStatisticService = bikeStatisticService;
    }

    @GetMapping()
    public BikeStatisticResponse getSoldBikes(@RequestParam int year){
        List<BikeResponse> soldBikesYearly = bikeStatisticService.getSoldBikesYearly(year);
        int numberOfBikesYearly = bikeStatisticService.getNumberOfSoldBikesYearly(year);
        double totalPriceYearly = bikeStatisticService.totalPriceYearly(year);
        //List<Integer> numberOfBikesQuarterly = bikeStatisticService.getNumberOfSoldBikesQuarterly(year, soldBikesYearly);
        List<Double> totalPriceQuarterly;
        return new BikeStatisticResponse(soldBikesYearly, numberOfBikesYearly, totalPriceYearly, null, null);
    }






}
