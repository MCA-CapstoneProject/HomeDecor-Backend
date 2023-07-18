package com.homedecor.rest.controller;

import com.homedecor.rest.dto.UserDto;
import com.homedecor.rest.entity.User;
import com.homedecor.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    public String generateAccessToken() {
        // Set the OAuth 2.0 authorization endpoint URL
        String authorizationEndpoint = "https://dev-72e1ark1yfj8hz53.us.auth0.com";

        // Set the client credentials obtained from the API provider
        String clientId = "aOghGIpqsYAVtv3HzCXATZXXDBgWMJGn";
        String clientSecret = "-hpu2xqPyOHDPu-8lOvMP2DZXexnswxNsVPVHsBfjYufsWcN9E6tN7_vv5J9-Rn4";

        // Create the request body with the required parameters
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "dev-72e1ark1yfj8hz53");
        requestBody.add("client_id", clientId);
        requestBody.add("client_secret", clientSecret);

        // Set the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // Create the request entity with the URL, method, headers, and body
        RequestEntity<MultiValueMap<String, String>> requestEntity = new RequestEntity<>(requestBody, headers, HttpMethod.POST, URI.create(authorizationEndpoint));

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Send the request to the authorization server
        ResponseEntity<AccessTokenResponse> responseEntity = restTemplate.exchange(requestEntity, AccessTokenResponse.class);

        // Retrieve the access token from the response
        AccessTokenResponse accessTokenResponse = responseEntity.getBody();
        String accessToken = accessTokenResponse.getAccessToken();

        return accessToken;
    }

    // Define a class to represent the access token response
    private static class AccessTokenResponse {
        private String accessToken;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }
    }


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto){
        String accessToken=generateAccessToken();
        // add check for username exists in a DB
        if(userService.existsByUsername(userDto.getUserName())){
            return new ResponseEntity<>("Username is already taken!"+accessToken, HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(userService.existsByEmail(userDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!"+accessToken, HttpStatus.BAD_REQUEST);
        }

        userService.createOrUpdateUser(userDto);

        return new ResponseEntity<>("User registered successfully"+accessToken, HttpStatus.OK);

    }
}

