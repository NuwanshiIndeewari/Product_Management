package com.example.productmanagement.repository;

import com.example.productmanagement.dto.ProductDTO;
import com.example.productmanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository  extends JpaRepository<Product,Long> {

    //Custom query:find a single products in a given category
    List<Product> findByCategoryIgnoreCase(String category);

    Optional<Product>findByProductNameIgnoreCase(String productName);



}