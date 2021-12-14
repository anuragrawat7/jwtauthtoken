package spring.security.jwtauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.security.jwtauth.requestDTO.UserRequestDTO;
import spring.security.jwtauth.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    //API to login and get Access Token
    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> userLogin(@RequestBody(required = true) UserRequestDTO userRequest){
        return userService.login(userRequest);
    }

    //API to create the User and get Access Token
    @GetMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody UserRequestDTO userRequest){
        return userService.createUser(userRequest);
    }

}
