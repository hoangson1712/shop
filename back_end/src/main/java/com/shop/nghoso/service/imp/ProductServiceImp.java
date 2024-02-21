package com.shop.nghoso.service.imp;

import com.shop.nghoso.entity.ProductEntity;
import com.shop.nghoso.payload.request.ProductRequest;
import com.shop.nghoso.payload.response.AllProductsResponse;
import com.shop.nghoso.repository.ProductRepository;
import com.shop.nghoso.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean addProduct(ProductRequest productRequest) {
        boolean isSuccess = false;
        try {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(productRequest.getName());
            productEntity.setImage(productRequest.getImage());
            productEntity.setCategory(productRequest.getCategory());
            productEntity.setNew_price(productRequest.getNewPrice());
            productEntity.setOld_price(productRequest.getOldPrice());
            productRepository.save(productEntity);
            isSuccess = true;
        }catch (Exception e){
            System.out.println("Lỗi " + e.getLocalizedMessage());
        }
        return isSuccess;
    }

    @Override
    public boolean removeProduct(ProductRequest productRequest) {
        boolean isSuccess = false;
        try {
            productRepository.deleteById(productRequest.getId());
            isSuccess = true;
        }catch (Exception e){
            System.out.println("Lỗi " + e.getLocalizedMessage());
        }
        return isSuccess;
    }

    @Override
    public List<AllProductsResponse> getAllProducts() {
        List<ProductEntity> list = productRepository.findAll();
        List<AllProductsResponse> list1 = new ArrayList<>();
        for (ProductEntity item : list) {
            AllProductsResponse response = new AllProductsResponse();
            response.setId(item.getId());
            response.setName(item.getName());
            response.setImage(item.getImage());
            response.setCategory(item.getCategory());
            response.setNewPrice(item.getNew_price());
            response.setOldPrice(item.getOld_price());
            list1.add(response);
        }
        return list1;
    }

    @Override
    public List<AllProductsResponse> getNewCollections() {
        List<ProductEntity> list = productRepository.getNewCollectons();
        List<AllProductsResponse> list1 = new ArrayList<>();
        for (ProductEntity item : list) {
            AllProductsResponse response = new AllProductsResponse();
            response.setId(item.getId());
            response.setName(item.getName());
            response.setImage(item.getImage());
            response.setCategory(item.getCategory());
            response.setNewPrice(item.getNew_price());
            response.setOldPrice(item.getOld_price());
            list1.add(response);
        }
        return list1;
    }

    @Override
    public List<AllProductsResponse> getPopularInWomen() {
        List<ProductEntity> list = productRepository.getPopularInWomen();
        List<AllProductsResponse> list1 = new ArrayList<>();
        for (ProductEntity item : list) {
            AllProductsResponse response = new AllProductsResponse();
            response.setId(item.getId());
            response.setName(item.getName());
            response.setImage(item.getImage());
            response.setCategory(item.getCategory());
            response.setNewPrice(item.getNew_price());
            response.setOldPrice(item.getOld_price());
            list1.add(response);
        }
        return list1;
    }
}
