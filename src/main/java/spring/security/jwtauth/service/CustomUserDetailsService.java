package spring.security.jwtauth.service;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import spring.security.jwtauth.entity.User;
import spring.security.jwtauth.repository.UserRepo;
import spring.security.jwtauth.security.util.SecurityUtil;

@Service
@AllArgsConstructor
@CrossOrigin(allowedHeaders = "*", origins = "*", value = "*")
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        return SecurityUtil.convert((User) userRepo.findByEmailId(emailId)
                .orElseThrow(() -> new UsernameNotFoundException("Bad Credentials")));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
