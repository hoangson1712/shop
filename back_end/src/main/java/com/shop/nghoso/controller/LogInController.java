package com.shop.nghoso.controller;

import com.shop.nghoso.payload.request.SignUpLogInRequest;
import com.shop.nghoso.payload.response.SignUpLogInResponse;
import com.shop.nghoso.service.JwtTokenService;
import com.shop.nghoso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LogInController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @PostMapping("")
    public ResponseEntity<?> logIn(@RequestBody SignUpLogInRequest signUpLogInRequest){
        SignUpLogInResponse signUpLogInResponse = new SignUpLogInResponse();
        if (userService.check(signUpLogInRequest)){
            if (userService.passCompare(signUpLogInRequest)){
                signUpLogInResponse.setToken(jwtTokenService.generateToken(signUpLogInRequest.getEmail()));
                signUpLogInResponse.setSuccess(true);
                return new ResponseEntity<>(signUpLogInResponse, HttpStatus.OK);
            }else {
                signUpLogInResponse.setSuccess(false);
                signUpLogInResponse.setErrors("Wrong Password");
                return new ResponseEntity<>(signUpLogInResponse, HttpStatus.OK);
            }
        }
        signUpLogInResponse.setSuccess(false);
        signUpLogInResponse.setErrors("Wrong Email Id");
        return new ResponseEntity<>(signUpLogInResponse, HttpStatus.OK);
    }
}
