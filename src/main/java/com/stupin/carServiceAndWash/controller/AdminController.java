package com.stupin.carServiceAndWash.controller;

import com.stupin.carServiceAndWash.dao.Service;
import com.stupin.carServiceAndWash.service.ServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("ui/admin")
public class AdminController {
    private final ServiceService service;

    public AdminController(ServiceService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String viewLoginAdminPage() {
        return "admin/admin_page";
    }

    @GetMapping("/add-service")
    public String getAddServicePage(Model model){
        List<Service> services = service.getAll();
        model.addAttribute("services", services);
        return "admin/add_services_page";
    }
//    @PostMapping("add-service")
//    public String getAddServicePage(){
//        List<Service> services = service.getAll();
//        model.addAttribute("services", services);
//        return "admin/add_services_page";
//    }

//    /ui/admin/
}
