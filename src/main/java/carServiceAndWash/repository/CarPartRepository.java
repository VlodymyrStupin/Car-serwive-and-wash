package carServiceAndWash.repository;

import com.stupin.carServiceAndWash.dto.CarPartDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPartRepository extends JpaRepository<CarPartDto, String> {
}
