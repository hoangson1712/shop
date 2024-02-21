package com.shop.nghoso.service;

public interface JwtTokenService {
    String generateToken(String email);
    String getEmailFromToken(String token);
    boolean validateToken(String token);
}
