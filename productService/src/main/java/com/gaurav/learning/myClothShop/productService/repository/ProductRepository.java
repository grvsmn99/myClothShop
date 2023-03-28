package com.gaurav.learning.myClothShop.productService.repository;

import com.gaurav.learning.myClothShop.productService.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
