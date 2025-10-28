package com.example.productmanagement.service;
import com.example.productmanagement.dto.ProductDTO;
import com.example.productmanagement.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProducts();
    List<ProductDTO> searchByCategory(String category);
    void deleteProductByName(String name);
}