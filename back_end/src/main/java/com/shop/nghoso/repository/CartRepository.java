package com.shop.nghoso.repository;

import com.shop.nghoso.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartEntity,Integer> {
    boolean existsByEmailAndProduct(String email,int product);

    CartEntity findByEmailAndProduct(String email,int product);

    List<CartEntity> findByEmail(String email);
}
