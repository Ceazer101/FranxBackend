package com.example.franxbackend.apis;

import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.dtos.BikeStatisticResponse;
import com.example.franxbackend.services.BikeStatisticService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/statistics-bike")
@CrossOrigin
public class BikeStatisticController {

    BikeStatisticService bikeStatisticService;

    public BikeStatisticController(BikeStatisticService bikeStatisticService) {
        this.bikeStatisticService = bikeStatisticService;
    }

    @GetMapping("/{year}")
    public BikeStatisticResponse getSoldBikes(@PathVariable int year){
        List<BikeResponse> soldBikesYearly = bikeStatisticService.getSoldBikesYearly(year);
        int numberOfBikesYearly = bikeStatisticService.getNumberOfSoldBikesYearly(year);
        double totalPriceYearly = bikeStatisticService.totalPriceYearly(year);
        List<Integer> numberOfBikesQuarterly = bikeStatisticService.getNumberOfSoldBikesQuarterly(year, soldBikesYearly);
        List<Double> totalPriceQuarterly = bikeStatisticService.getTotalPriceQuarterly(year, soldBikesYearly);
        return new BikeStatisticResponse(soldBikesYearly, numberOfBikesYearly, totalPriceYearly, numberOfBikesQuarterly, totalPriceQuarterly);
    }






}
