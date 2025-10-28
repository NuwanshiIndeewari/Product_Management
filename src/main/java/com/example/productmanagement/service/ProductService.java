package com.example.productmanagement.service;
import com.example.productmanagement.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    ProductDTO addProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProducts();
    List<ProductDTO> searchByCategory(String category);
    void deleteProductByName(String name);
}