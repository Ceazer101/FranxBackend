package com.example.franxbackend.apis;

import com.example.franxbackend.dtos.BikeRequest;
import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.services.BikeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/bikes")
@CrossOrigin
public class BikeController {
    BikeService bikeService;

    public BikeController(BikeService bikeService){
        this.bikeService = bikeService;
    }

    @PostMapping
    public BikeResponse addBike(@RequestBody BikeRequest body){
        return bikeService.addBike(body);
    }
}
