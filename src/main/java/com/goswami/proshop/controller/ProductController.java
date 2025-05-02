package com.goswami.proshop.controller;

import com.goswami.proshop.entity.Product;
import com.goswami.proshop.service.ProductService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<Product>> getAllProducts() {
    List<Product> products = productService.getAllProducts();

    return new ResponseEntity<>(products, HttpStatus.OK);
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable String id) {
    Optional<Product> product = productService.getProductById(id);

      if (product.isPresent()) {
          return new ResponseEntity<>(product.get(), HttpStatus.OK);
      }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

  }

  @PostMapping("")
  public ResponseEntity<Void> createProduct(@RequestBody Product product) {
    try {
      return new ResponseEntity<>(HttpStatus.CREATED);
    } catch (RuntimeException e) {
      log.error("Exception while saving the product {}", e.getMessage());
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}
