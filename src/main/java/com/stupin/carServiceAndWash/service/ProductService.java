package com.stupin.carServiceAndWash.service;

import com.stupin.carServiceAndWash.converter.CarConverter;
import com.stupin.carServiceAndWash.converter.ProductConverter;
import com.stupin.carServiceAndWash.converter.UserConverter;
import com.stupin.carServiceAndWash.dao.CarDao;
import com.stupin.carServiceAndWash.dao.ProductDao;
import com.stupin.carServiceAndWash.dto.Car;
import com.stupin.carServiceAndWash.dto.Product;
import com.stupin.carServiceAndWash.dto.User;
import com.stupin.carServiceAndWash.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.stupin.carServiceAndWash.converter.ProductConverter.toDto;


@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getById(String id) {
        return ProductConverter.toDto(productRepository.findById(id).orElseThrow(() -> new RuntimeException("")));
    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(it -> products.add(new Product(it.getId(),
                it.getPrice(), it.getProductName())));
        return products;
    }
    public Product save(Product product) {
        ProductDao dao;
        if (product.getId() != null && productRepository.existsById(product.getId())) {
            dao = productRepository.findById(product.getId()).get();
            dao.setPrice(product.getPrice());
            dao.setProductName(product.getProductName());
        } else {
            dao = ProductConverter.toDao(product);
        }
        return toDto(productRepository.save(dao));
    }
    @Transactional
    public void delete(String id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
    }
}