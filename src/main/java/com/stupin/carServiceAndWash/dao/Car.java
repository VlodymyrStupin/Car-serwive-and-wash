package com.stupin.carServiceAndWash.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    String id;
    private int odometer;
    private int year;
    private String brand;
    private String model;
    private String registrationPlate;
    private String vinCode;
    private List<CarPart> carParts;
}
