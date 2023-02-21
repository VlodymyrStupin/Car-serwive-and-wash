package com.stupin.carServiceAndWash.repository;

import java.util.List;

import com.stupin.carServiceAndWash.dao.AdminDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminDao, Long> {

    AdminDao findByEmail(String user);

    List<AdminDao> findByRole(String user);
}