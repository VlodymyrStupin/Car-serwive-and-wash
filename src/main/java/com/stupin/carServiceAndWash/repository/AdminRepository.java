package com.stupin.carServiceAndWash.repository;

import com.stupin.carServiceAndWash.dto.AdminDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminDto, Integer> {
}
