package com.gaurav.learning.myClothShop.productService.controllers;


import com.gaurav.learning.myClothShop.productService.models.ProductRequest;
import com.gaurav.learning.myClothShop.productService.models.ProductResponse;
import com.gaurav.learning.myClothShop.productService.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest){
        log.info("productRequest = "+productRequest.toString());
        ProductResponse product = productService.addProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable(name="id") String userId){
        log.info("id = "+userId);
        ProductResponse product = productService.getProduct(userId);
        return ResponseEntity.ok(product);
    }


    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProduct(){
        List<ProductResponse> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }
}
