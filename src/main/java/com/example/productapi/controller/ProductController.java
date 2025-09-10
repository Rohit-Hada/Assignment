package com.example.productapi.controller;

import com.example.productapi.entity.Product;
import com.example.productapi.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    
    // Get all products
    @Operation(summary = "Get all products", description = "Retrieve a list of all products")
    @ApiResponse(responseCode = "200", description = "List of products retrieved successfully")
    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }

    
    // Get product by ID
    @Operation(summary = "Get product by ID", description = "Retrieve a product using its unique ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Product retrieved successfully"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getProductById(id));
    }
    

    // Create a new product
    @Operation(summary = "Create a new product", description = "Add a new product to the system")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Product created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid product data")
    })
    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(service.createProduct(product));
    }

    // Update an existing product
    @Operation(summary = "Update existing product", description = "Update the details of an existing product by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Product updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid product data"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody Product product) {
        return ResponseEntity.ok(service.updateProduct(id, product));
    }

    // Delete a product using id
    @Operation(summary = "Delete a product", description = "Remove a product from the system by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Product deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}



