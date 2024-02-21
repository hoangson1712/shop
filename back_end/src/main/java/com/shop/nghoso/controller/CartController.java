package com.shop.nghoso.controller;

import com.shop.nghoso.payload.request.CartRequest;
import com.shop.nghoso.service.CartService;
import com.shop.nghoso.service.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<?> addCart(@RequestHeader String auth_token, @RequestBody CartRequest cartRequest){
        boolean isSuccess = false;
        if (jwtTokenService.validateToken(auth_token)){
            isSuccess = cartService.addCart(jwtTokenService.getEmailFromToken(auth_token),cartRequest.getProduct());
        }
        return new ResponseEntity<>(isSuccess, HttpStatus.OK);
    }

    @PostMapping("/remove")
    public ResponseEntity<?> removeCart(@RequestHeader String auth_token, @RequestBody CartRequest cartRequest){
        boolean isSuccess = false;
        if (jwtTokenService.validateToken(auth_token)){
            isSuccess = cartService.removeCart(jwtTokenService.getEmailFromToken(auth_token),cartRequest.getProduct());
        }
        return new ResponseEntity<>(isSuccess, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCart(@RequestHeader String auth_token){
        Map<Integer, Integer> cart = new HashMap<>();
        if (jwtTokenService.validateToken(auth_token)){
            cart = cartService.getAllCart(jwtTokenService.getEmailFromToken(auth_token));
        }
        return new ResponseEntity<>(cart,HttpStatus.OK);
    }
}
