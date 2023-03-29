package com.gaurav.learning.myClothShop.productService.services;

import com.gaurav.learning.myClothShop.productService.models.ProductRequest;
import com.gaurav.learning.myClothShop.productService.models.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse addProduct(ProductRequest productRequest);

    ProductResponse getProduct(String userId);

    List<ProductResponse> getProducts();
}
