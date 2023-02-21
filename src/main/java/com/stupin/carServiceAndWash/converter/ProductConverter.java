package com.stupin.carServiceAndWash.converter;

import com.stupin.carServiceAndWash.dao.ProductDao;
import com.stupin.carServiceAndWash.dao.UserDao;
import com.stupin.carServiceAndWash.dto.Product;
import com.stupin.carServiceAndWash.dto.User;

public class ProductConverter {
    public static Product toDto(ProductDao productDao) {
        return new Product(
                productDao.getId(),
                productDao.getPrice(),
                productDao.getProductName());
    }

    public static ProductDao toDao(Product product) {
        return new ProductDao(
                product.getId(),
                product.getPrice(),
                product.getProductName());
    }
}
