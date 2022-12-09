package com.example.franxbackend.dtos;

import com.example.franxbackend.entities.Bike;
import com.example.franxbackend.entities.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BikeResponse {

    private String frameNumber;
    private String model;
    private String brand;
    private double price;

    private Status status;

    private LocalDate sellDate;

    public BikeResponse(Bike bike) {
        this.frameNumber = bike.getFrameNumber();
        this.model = bike.getModel();
        this.brand = bike.getBrand();
        this.price = bike.getPrice();
        this.status = bike.getStatus();
        this.sellDate = bike.getSellDate();
    }

}
