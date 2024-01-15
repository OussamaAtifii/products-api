package com.atifi.products.services.impl;

import com.atifi.products.models.entities.ProductEntity;
import com.atifi.products.repositories.ProductRepository;
import com.atifi.products.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        System.out.println(productEntity);
        return productRepository.save(productEntity);
    }

    @Override
    public Iterable<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductEntity> getProductById(Long id) {
        return productRepository.findById(id);
    }
}
