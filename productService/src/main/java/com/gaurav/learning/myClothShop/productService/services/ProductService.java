package com.gaurav.learning.myClothShop.productService.services;

import com.gaurav.learning.myClothShop.productService.models.ProductRequest;
import com.gaurav.learning.myClothShop.productService.models.ProductResponse;

public interface ProductService {

    ProductResponse addProduct(ProductRequest productRequest);
}
