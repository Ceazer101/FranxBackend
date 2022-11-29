package com.example.franxbackend.repositories;

import com.example.franxbackend.entities.Bike;
import com.example.franxbackend.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BikeStatisticRepository extends JpaRepository<Bike, String> {

    //List<Bike> findBikeByStatus(Status status);
    List<Bike> findBikesByStatus(Status status);

}
