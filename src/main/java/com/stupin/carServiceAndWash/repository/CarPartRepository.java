package com.stupin.carServiceAndWash.repository;

import com.stupin.carServiceAndWash.dao.CarPartDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPartRepository extends JpaRepository<CarPartDao, String> {
}
