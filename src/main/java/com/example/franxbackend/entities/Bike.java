package com.example.franxbackend.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bike {

    @Id
    private String frameNumber;
    private String model;
    private String brand;
    private double price;

    private String sellDate;
    private Status status;

}
