package com.example.productmanagement.controller;


import com.example.productmanagement.dto.ProductDTO;
import com.example.productmanagement.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @PostMapping
    public ResponseEntity<ProductDTO>addProduct(@Valid @RequestBody ProductDTO productDTO){
        ProductDTO newProductDTO=productService.addProduct(productDTO);
        return new ResponseEntity<>(newProductDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity <List<ProductDTO>> getByCategory(@PathVariable String category) {
        List<ProductDTO> products = productService.searchByCategory(category);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteByName(@PathVariable String name) {
        productService.deleteProductByName(name);
        return ResponseEntity.ok("Product deleted successfully");
    }

}