package carServiceAndWash.service;

import com.stupin.carServiceAndWash.dao.Service;
import com.stupin.carServiceAndWash.repository.ServiceRepository;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }
    public List<Service> getAll() {
        List<Service> services = new ArrayList<>();
        serviceRepository.findAll().forEach(it -> services.add(new Service(it.getId(),
                it.getPrice(), it.getNameOfService())));
        return services;
    }

}
