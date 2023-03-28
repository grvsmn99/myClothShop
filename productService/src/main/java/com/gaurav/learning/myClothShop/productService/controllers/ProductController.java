package com.gaurav.learning.myClothShop.productService.controllers;


import com.gaurav.learning.myClothShop.productService.entities.Product;
import com.gaurav.learning.myClothShop.productService.models.ProductRequest;
import com.gaurav.learning.myClothShop.productService.models.ProductResponse;
import com.gaurav.learning.myClothShop.productService.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    public Response<ProductResponse> addProduct(@RequestBody ProductRequest productRequest){
        ProductResponse product = productService.addProduct(productRequest);
        return new ResponseEntity(product, HttpStatus.CREATED);
    }
}
