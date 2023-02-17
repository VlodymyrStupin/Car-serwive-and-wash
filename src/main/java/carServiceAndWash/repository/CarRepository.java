package carServiceAndWash.repository;

import com.stupin.carServiceAndWash.dto.CarDto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<CarDto, String> {
}
