package com.example.productmanagement.service.impl;

import com.example.productmanagement.dto.ProductDTO;
import com.example.productmanagement.model.Product;
import com.example.productmanagement.repository.ProductRepository;
import com.example.productmanagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        Product savedProduct = productRepository.save(product);
        return toProductDTO(savedProduct);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::toProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> searchByCategory(String category) {
        return productRepository.findByCategoryIgnoreCase(category).stream()
                .map(this::toProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProductByName(String name) {
        productRepository.findByProductNameIgnoreCase(name)
                .ifPresent(productRepository::delete);
    }

    private ProductDTO toProductDTO(Product product) {
        return new ProductDTO(
                product.getProductName(),
                product.getCategory(),
                product.getPrice(),
                product.getQuantity()
        );
    }
}