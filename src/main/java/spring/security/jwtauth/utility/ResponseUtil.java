package spring.security.jwtauth.utility;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import spring.security.jwtauth.entity.User;
import spring.security.jwtauth.security.util.JwtUtil;

import java.util.HashMap;

@Component
@AllArgsConstructor
@Slf4j
public class ResponseUtil {

    private JwtUtil jwtUtil;

    public ResponseEntity<?> accountCreationResponse(User user){
        final var headers = new HttpHeaders();
        final var response = new HashMap<>();
        try {
            response.put("status", HttpStatus.OK.value());
            response.put("message", "You Can use Your Credentials To Login Now");
            headers.set("Authorization", "Bearer "+ jwtUtil.generateToken(user));
        } catch (Exception exception) {
            log.error("Failed To Generate Valid JSON {}", exception);
        }
        return ResponseEntity.ok().headers(headers).body(response);
    }

    public ResponseEntity<?> loginSuccessResponse(User user){
        final var headers = new HttpHeaders();
        final var response = new HashMap<>();
        try {
            response.put("status", HttpStatus.OK.value());
            response.put("jwt", jwtUtil.generateToken(user));
            headers.set("Authorization", "Bearer " + jwtUtil.generateToken(user));
        } catch (Exception exception) {
            log.error("Failed To Generate Valid JSON {}", exception);
        }
        return ResponseEntity.ok().headers(headers).body(response);
    }
}
