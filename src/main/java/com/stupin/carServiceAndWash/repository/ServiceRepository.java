package com.stupin.carServiceAndWash.repository;

import com.stupin.carServiceAndWash.dao.ServiceDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceDao, String> {
}
