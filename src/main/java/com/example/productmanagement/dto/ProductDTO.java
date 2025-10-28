package com.example.productmanagement.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotBlank(message = "Product Name is required.")
    private String productName;
    @NotBlank(message = "Category must be required.")
    private String category;
    @Min(value = 1, message = "Price must be positive")
    private double price;
    @Min(value = 1, message = "Quantity must be positive")
    private int quantity;


}
