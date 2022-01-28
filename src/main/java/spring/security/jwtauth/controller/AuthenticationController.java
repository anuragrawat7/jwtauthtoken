package spring.security.jwtauth.controller;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.security.jwtauth.dto.request.UserRequestDTO;
import spring.security.jwtauth.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    //API to create the User and get Access Token
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody UserRequestDTO userRequest){
        return userService.createUser(userRequest);
    }

    //API to login and get Access Token
    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> userLogin(@RequestBody UserRequestDTO userRequest){
        return userService.login(userRequest);
    }

    //API to get All users using Authentication Token
    @GetMapping(value = "/getUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllUsers(@Parameter(hidden = true) @RequestHeader(name = "Authorization") String headers){
        return userService.getAllUsers();
    }

}
