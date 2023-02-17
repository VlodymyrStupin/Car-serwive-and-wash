package com.stupin.carServiceAndWash.controller;

import com.stupin.carServiceAndWash.dao.Service;
import com.stupin.carServiceAndWash.repository.ServiceRepository;
import com.stupin.carServiceAndWash.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ServiceController {
    private final ServiceRepository serviceRepository;
    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceRepository serviceRepository, ServiceService serviceService) {
        this.serviceRepository = serviceRepository;
        this.serviceService = serviceService;
    }
@GetMapping("/calculator")
    public String getCalculatorPage(Model model) {
    List<Service> services = serviceService.getAll();
    model.addAttribute("services", services);
        return "calculator_page.html";
    }
}
