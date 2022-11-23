package com.example.franxbackend.dtos;

import com.example.franxbackend.entities.Bike;
import com.example.franxbackend.entities.Status;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class BikeRequest {

    private String frameNumber;
    private String model;
    private String brand;
    private double price;
    private String sellDate;
    private Status status;


    public static Bike getBikeEntity(BikeRequest bikeRequest){
        return Bike.builder()
                .frameNumber(bikeRequest.frameNumber)
                .brand(bikeRequest.brand)
                .model(bikeRequest.model)
                .price(bikeRequest.price)
                .sellDate(bikeRequest.sellDate)
                .status(bikeRequest.status)
                .build();

    }

    public BikeRequest(Bike bike) {
        this.frameNumber = bike.getFrameNumber();
        this.model = bike.getModel();
        this.brand = bike.getBrand();
        this.price = bike.getPrice();
        this.sellDate = bike.getSellDate();
        this.status = bike.getStatus();
    }
}
