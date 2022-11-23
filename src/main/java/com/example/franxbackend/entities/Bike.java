package com.example.franxbackend.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Bike {

    @Id
    private String frameNumber;
    private String model;
    private String brand;
    private double price;

    private String sellDate;
    private Status status;
}
