package carServiceAndWash.converter;

import com.stupin.carServiceAndWash.dao.User;
import com.stupin.carServiceAndWash.dto.UserDto;

public class UserConverter {
    public static User fromEntity(UserDto entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getSurname(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getPhoneNumber());
    }

    public static UserDto toEntity(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getPassword(),
                user.getPhoneNumber());
    }
}
