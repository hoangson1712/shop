package com.shop.nghoso.service.imp;

import com.shop.nghoso.service.JwtTokenService;
import com.shop.nghoso.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenServiceImp implements JwtTokenService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public String generateToken(String email) {
        return jwtTokenUtil.generateToken(email);
    }

    @Override
    public String getEmailFromToken(String token) {
        return jwtTokenUtil.getEmailFromToken(token);
    }

    @Override
    public boolean validateToken(String token) {
        return jwtTokenUtil.validateToken(token);
    }
}
