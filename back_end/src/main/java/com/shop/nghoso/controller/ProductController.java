package com.shop.nghoso.controller;

import com.shop.nghoso.payload.request.ProductRequest;
import com.shop.nghoso.payload.response.AllProductsResponse;
import com.shop.nghoso.payload.response.ProductResponse;
import com.shop.nghoso.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductRequest product){
        boolean isSuccess = productService.addProduct(product);
        ProductResponse productResponse = new ProductResponse();
        productResponse.setSuccess(isSuccess);
        productResponse.setName(product.getName());
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeProduct(@RequestBody ProductRequest product){
        boolean isSuccess = productService.removeProduct(product);
        ProductResponse productResponse = new ProductResponse();
        productResponse.setSuccess(isSuccess);
        productResponse.setName(product.getName());
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProducts(){
        List<AllProductsResponse> list = productService.getAllProducts();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/newcollections")
    public ResponseEntity<?> getNewCollections(){
        List<AllProductsResponse> list = productService.getNewCollections();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/popularinwomen")
    public ResponseEntity<?> getPopularInWomen(){
        List<AllProductsResponse> list = productService.getPopularInWomen();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
