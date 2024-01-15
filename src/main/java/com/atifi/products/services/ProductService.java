package com.atifi.products.services;

import com.atifi.products.models.entities.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductService {
    ProductEntity save(ProductEntity productEntity);

    Iterable<ProductEntity> getAllProducts();

    Optional<ProductEntity> getProductById(Long id);
}
