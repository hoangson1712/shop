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
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @PostMapping("")
    public ResponseEntity<?> signUp(@RequestBody SignUpLogInRequest signUpLogInRequest){
        SignUpLogInResponse signUpLogInResponse = new SignUpLogInResponse();
        if (userService.check(signUpLogInRequest)){
            signUpLogInResponse.setSuccess(false);
            signUpLogInResponse.setErrors("existing user found with same email address");
            return new ResponseEntity<>(signUpLogInResponse,HttpStatus.BAD_REQUEST);
        }
        signUpLogInResponse.setSuccess(userService.addUser(signUpLogInRequest));
        signUpLogInResponse.setToken(jwtTokenService.generateToken(signUpLogInRequest.getEmail()));
        return new ResponseEntity<>(signUpLogInResponse,HttpStatus.OK);
    }
}
