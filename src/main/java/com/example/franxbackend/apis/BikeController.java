package com.example.franxbackend.apis;

import com.example.franxbackend.dtos.BikeRequest;
import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.entities.Bike;
import com.example.franxbackend.services.BikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        System.out.println("hej");
        return bikeService.addBike(body);
    }

    @GetMapping
    public List<BikeResponse> getAllBikes(){
        List<BikeResponse> response = bikeService.getAllBikes();
        return response;
    }

    @GetMapping("/{frameNumber}")
    public BikeResponse getSignleBike(@PathVariable String frameNumber){
        BikeResponse bikeResponse = bikeService.getSingleBike(frameNumber);
        return bikeResponse;
    }


}
