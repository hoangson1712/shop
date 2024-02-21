package com.shop.nghoso.service;

import java.util.Map;

public interface CartService {

    boolean addCart(String email,int product);
    boolean removeCart(String email,int product);
    Map<Integer, Integer> getAllCart(String email);
}
