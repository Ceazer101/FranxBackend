package com.example.franxbackend.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductStatistic {

    @Id
    private int productNumber;
    private String productName;
    private int numberOfUnits;
    private double unitPrice;

    @CreationTimestamp
    private LocalDateTime dateSold;


}
