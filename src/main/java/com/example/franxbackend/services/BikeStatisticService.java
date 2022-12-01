package com.example.franxbackend.services;

import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.dtos.BikeStatisticResponse;
import com.example.franxbackend.entities.Bike;
import com.example.franxbackend.entities.Status;
import com.example.franxbackend.repositories.BikeStatisticRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BikeStatisticService {

    BikeStatisticRepository bikeStatisticRepository;

    public BikeStatisticService(BikeStatisticRepository bikeStatisticRepository) {
        this.bikeStatisticRepository = bikeStatisticRepository;
    }

    public List<BikeResponse> getSoldBikesYearly(int year){
        List<Bike> bikesSoldGivenYear = bikeStatisticRepository
                .findBikesByStatus(Status.SOLD);
        bikesSoldGivenYear.removeIf(bike -> year != bike.getSellDate().getYear());

        List<BikeResponse> response = bikesSoldGivenYear.stream().map(bike ->
                new BikeResponse(bike)).collect(Collectors.toList());

        return response;
    }

    public Integer getNumberOfSoldBikesYearly(int year){
        return getSoldBikesYearly(year).size();
    }

    public double totalPriceYearly(int year){
        List<BikeResponse> bikes = getSoldBikesYearly(year);
        double totalPrice = 0;

        for (BikeResponse b: bikes) {
            totalPrice += b.getPrice();
        }
        return totalPrice;
    }


    //Vil gerne have en liste med 4 integers, der hver især er antal cykler solgt i det givne kvartal
    public List<Integer> getNumberOfSoldBikesQuarterly(int year, List<BikeResponse> bikes){
        List<LocalDate> quarter1 = new ArrayList<>(LocalDate.of(year, Month.JANUARY, 1)
                .datesUntil(LocalDate.of(year, Month.MARCH, 31)).toList());
        List<LocalDate> quarter2 = LocalDate.of(year, Month.APRIL, 1)
                .datesUntil(LocalDate.of(year, Month.JUNE, 30)).toList();
        List<LocalDate> quarter3 = LocalDate.of(year, Month.JULY, 1)
                .datesUntil(LocalDate.of(year, Month.SEPTEMBER, 30)).toList();
        List<LocalDate> quarter4 = LocalDate.of(year, Month.OCTOBER, 1)
                .datesUntil(LocalDate.of(year, Month.DECEMBER, 31)).toList();

        ArrayList<Integer> quarterlyNumbers = new ArrayList<>();
        int q1 = 0, q2 = 0, q3 = 0, q4 = 0;

        for (BikeResponse b : bikes){
           if(quarter1.contains(b.getSellDate())){
                q1++;
            }
            if(quarter2.contains(b.getSellDate())){
                q2++;
            }
            if(quarter3.contains(b.getSellDate())){
                q3++;
            }
            if(quarter4.contains(b.getSellDate())){
                q4++;
            }
        }

        quarterlyNumbers.add(q1);
        quarterlyNumbers.add(q2);
        quarterlyNumbers.add(q3);
        quarterlyNumbers.add(q4);

        return quarterlyNumbers;
    }

    //Samme som ovenfor, bare med pris istedet for antal
    public List<Double> getTotalPriceQuarterly(int year, List<BikeResponse> bikes){
        List<LocalDate> quarter1 = new ArrayList<>(LocalDate.of(year, Month.JANUARY, 1)
                .datesUntil(LocalDate.of(year, Month.MARCH, 31)).toList());
        List<LocalDate> quarter2 = LocalDate.of(year, Month.APRIL, 1)
                .datesUntil(LocalDate.of(year, Month.JUNE, 30)).toList();
        List<LocalDate> quarter3 = LocalDate.of(year, Month.JULY, 1)
                .datesUntil(LocalDate.of(year, Month.SEPTEMBER, 30)).toList();
        List<LocalDate> quarter4 = LocalDate.of(year, Month.OCTOBER, 1)
                .datesUntil(LocalDate.of(year, Month.DECEMBER, 31)).toList();

        ArrayList<Double> quarterlyNumbers = new ArrayList<>();
        double q1 = 0, q2 = 0, q3 = 0, q4 = 0;

        for (BikeResponse b : bikes){
            if(quarter1.contains(b.getSellDate())){
                q1 += b.getPrice();
            }
            if(quarter2.contains(b.getSellDate())){
                q2 += b.getPrice();
            }
            if(quarter3.contains(b.getSellDate())){
                q3 += b.getPrice();
            }
            if(quarter4.contains(b.getSellDate())){
                q4 += b.getPrice();
            }
        }

        quarterlyNumbers.add(q1);
        quarterlyNumbers.add(q2);
        quarterlyNumbers.add(q3);
        quarterlyNumbers.add(q4);

        return quarterlyNumbers;
    }

}
