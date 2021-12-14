package spring.security.jwtauth.security.util;

import lombok.experimental.UtilityClass;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@UtilityClass
public class SecurityUtil {
    public User convert(spring.security.jwtauth.entity.User user) {
        return new User(user.getEmailId(), user.getPassword(), List.of());
    }
}
