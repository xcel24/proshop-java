package com.goswami.proshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
@AllArgsConstructor
public class Product {
    @Not
    private String name;
    private String image;
    private String description;
    private String brand;
    private String category;
    private double price;
    private int countInStock;
    private double rating;
    private int numReviews;
}
