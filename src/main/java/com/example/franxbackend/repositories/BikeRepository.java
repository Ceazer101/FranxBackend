package com.example.franxbackend.repositories;

import com.example.franxbackend.entities.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, String> {
    public Bike findBikeByFrameNumber(String frameNumber);
}
