package carServiceAndWash.repository;

import com.stupin.carServiceAndWash.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserDto, Integer> {

    @Query("SELECT u FROM UserDto u WHERE u.email = ?1")
    UserDto findByEmail(String email);
    @Query("SELECT u FROM UserDto u WHERE u.phoneNumber = ?1")
    UserDto findByPhoneNumber(String phoneNumber);
}
