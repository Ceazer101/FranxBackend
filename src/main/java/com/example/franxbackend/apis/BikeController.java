package com.example.franxbackend.apis;

import com.example.franxbackend.dtos.BikeRequest;
import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.entities.Bike;
import com.example.franxbackend.services.BikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/{frameNumber}")
    public ResponseEntity<Boolean> editBike(@RequestBody BikeRequest body, @PathVariable String frameNumber){
        bikeService.editBike(body, frameNumber);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
