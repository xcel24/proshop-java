package com.goswami.proshop.service;

import com.goswami.proshop.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> getProductById(String id);

    Product saveProduct(Product product);
}
