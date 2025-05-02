package com.goswami.proshop.service.impl;

import com.goswami.proshop.entity.Product;
import com.goswami.proshop.repository.ProductRepository;
import com.goswami.proshop.service.ProductService;
import com.mongodb.DuplicateKeyException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(String id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        try {
            return this.productRepository.save(product);
        } catch (DuplicateKeyException e) {
            throw new RuntimeException("Product with same ID exists");
        } catch (Exception e) {
            throw new RuntimeException("Failed to save product " + e.getMessage());
        }
    }
}
