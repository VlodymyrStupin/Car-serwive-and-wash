package com.stupin.carServiceAndWash.converter;

import com.stupin.carServiceAndWash.dao.CarDao;

import com.stupin.carServiceAndWash.dto.Car;
import com.stupin.carServiceAndWash.dto.User;

import static com.stupin.carServiceAndWash.converter.UserConverter.toDto;
import static com.stupin.carServiceAndWash.converter.UserConverter.toDao;
public class CarConverter {
    public static Car carToDto(CarDao carDao) {
        return new Car(
                carDao.getId(),
                carDao.getBrand(),
                carDao.getModel(),
                carDao.getOdometer(),
                carDao.getProductionYear(),
                toDto(carDao.getUserDao()));

    }

    public static CarDao carToDao(Car car) {
        return new CarDao(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getOdometer(),
                car.getProductionYear(),
                toDao(car.getUser()));
    }
}
