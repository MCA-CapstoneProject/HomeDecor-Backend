package com.homedecor.rest.controller;

import com.homedecor.rest.dto.UserDto;
import com.homedecor.rest.entity.User;
import com.homedecor.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/secured/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto){

        // add check for username exists in a DB
        if(userService.existsByUsername(userDto.getUserName())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(userService.existsByEmail(userDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        userService.createOrUpdateUser(userDto);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }
}

