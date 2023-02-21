package com.stupin.carServiceAndWash.repository;

import com.stupin.carServiceAndWash.dao.CarDao;
import com.stupin.carServiceAndWash.dao.ProductDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<ProductDao, String> {

    ProductDao getById(String id);
}
