package com.shop.nghoso.repository;

import com.shop.nghoso.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    @Query("SELECT p FROM product p ORDER BY p.id DESC LIMIT 8")
    List<ProductEntity> getNewCollectons();

    @Query("SELECT p from product p where p.category = 'women' ORDER BY p.id limit 4")
    List<ProductEntity> getPopularInWomen();
}
