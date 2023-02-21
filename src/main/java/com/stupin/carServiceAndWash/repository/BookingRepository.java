package com.stupin.carServiceAndWash.repository;

import com.stupin.carServiceAndWash.dao.BookingDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingDao, Integer> {
}
