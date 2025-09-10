package com.example.productapi.service;

import com.example.productapi.entity.Product;
import com.example.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found with id " + id));
    }

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existing = getProductById(id);
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        return repository.save(existing);
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}