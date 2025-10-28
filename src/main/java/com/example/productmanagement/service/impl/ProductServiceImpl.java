package com.example.productmanagement.service.impl;

import com.example.productmanagement.dto.ProductDTO;
import com.example.productmanagement.model.Product;
import com.example.productmanagement.repository.ProductRepository;
import com.example.productmanagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = new Product(
                null,
                productDTO.getProductName(),
                productDTO.getCategory(),
                productDTO.getPrice(),
                productDTO.getQuantity()
        );
        return productRepository.save(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductDTO> searchByCategory(String category) {
        return productRepository.findByCategoryIgnoreCase(category);
    }

    @Override
    public void deleteProductByName(String name) {
        productRepository.findByProductNameIgnoreCase(name)
                .ifPresent(productRepository::delete);
    }
}
