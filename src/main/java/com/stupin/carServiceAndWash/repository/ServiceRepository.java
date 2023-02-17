package com.stupin.carServiceAndWash.repository;

import com.stupin.carServiceAndWash.dto.ServiceDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceDto, String> {
}
