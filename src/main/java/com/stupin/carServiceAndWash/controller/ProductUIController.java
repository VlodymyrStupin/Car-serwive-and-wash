package com.stupin.carServiceAndWash.controller;

import com.stupin.carServiceAndWash.dto.Product;
import com.stupin.carServiceAndWash.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("")
public class ProductUIController {

    private final ProductService productService;

    @Autowired
    public ProductUIController(ProductService productService) {
        this.productService = productService;
    }


}
