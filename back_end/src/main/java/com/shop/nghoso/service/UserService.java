package com.shop.nghoso.service;

import com.shop.nghoso.payload.request.SignUpLogInRequest;

public interface UserService {
    boolean check(SignUpLogInRequest signUpLogInRequest);
    boolean addUser(SignUpLogInRequest signUpLogInRequest);
    boolean passCompare(SignUpLogInRequest signUpLogInRequest);
}
