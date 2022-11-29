package com.example.franxbackend.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.stream.Collectors;

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

    private LocalDate sellDate;
    private Status status;
    //@CreationTimestamp
    //private LocalDateTime created;
    //@UpdateTimestamp
    //private LocalDateTime updated;





}
