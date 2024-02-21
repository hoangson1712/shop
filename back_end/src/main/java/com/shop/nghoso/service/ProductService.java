package com.shop.nghoso.service;

import com.shop.nghoso.payload.request.ProductRequest;
import com.shop.nghoso.payload.response.AllProductsResponse;

import java.util.List;

public interface ProductService {
    boolean addProduct(ProductRequest productRequest);
    boolean removeProduct(ProductRequest productRequest);
    List<AllProductsResponse> getAllProducts();
    List<AllProductsResponse> getNewCollections();
    List<AllProductsResponse> getPopularInWomen();
}
