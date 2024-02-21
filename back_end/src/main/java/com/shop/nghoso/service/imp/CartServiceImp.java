package com.shop.nghoso.service.imp;

import com.shop.nghoso.entity.CartEntity;
import com.shop.nghoso.repository.CartRepository;
import com.shop.nghoso.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImp implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Override
    public boolean addCart(String email, int product) {
        boolean isSuccess = false;
        try {
            if (cartRepository.existsByEmailAndProduct(email, product)){
                CartEntity cartEntity = cartRepository.findByEmailAndProduct(email,product);
                int count = cartEntity.getQuantity();
                count += 1;
                cartEntity.setQuantity(count);
                cartRepository.save(cartEntity);
            }else {
                CartEntity cartEntity = new CartEntity();
                cartEntity.setEmail(email);
                cartEntity.setQuantity(1);
                cartEntity.setProduct(product);
                cartRepository.save(cartEntity);
            }
            isSuccess = true;
        }catch (Exception e){
            System.out.println("Lỗi " + e.getLocalizedMessage());
        }
        return isSuccess;
    }

    @Override
    public boolean removeCart(String email, int product) {
        boolean isSuccess = false;
        try {
            if (cartRepository.existsByEmailAndProduct(email, product)){
                CartEntity cartEntity = cartRepository.findByEmailAndProduct(email,product);
                if (cartEntity.getQuantity()>1){
                    int count = cartEntity.getQuantity();
                    count -= 1;
                    cartEntity.setQuantity(count);
                    cartRepository.save(cartEntity);
                }else {
                    cartRepository.delete(cartEntity);
                }
                isSuccess = true;
            }
        }catch (Exception e){
            System.out.println("Lỗi " + e.getLocalizedMessage());
        }
        return isSuccess;
    }

    @Override
    public Map<Integer, Integer> getAllCart(String email) {
        List<CartEntity> list = cartRepository.findByEmail(email);
        Map<Integer, Integer> cart = new HashMap<>();
        for (int index = 0; index < 10; index++) {
            cart.put(index, 0);
        }
        for (CartEntity item:list) {
            cart.put(item.getProduct(), item.getQuantity());
        }
        return cart;
    }
}
