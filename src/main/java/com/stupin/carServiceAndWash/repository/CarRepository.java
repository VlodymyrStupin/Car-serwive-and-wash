package com.stupin.carServiceAndWash.repository;

import com.stupin.carServiceAndWash.dao.CarDao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<CarDao, String> {
}
