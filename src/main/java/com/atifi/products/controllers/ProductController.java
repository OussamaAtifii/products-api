package com.atifi.products.controllers;

import com.atifi.products.models.entities.ProductEntity;
import com.atifi.products.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public Iterable<ProductEntity> getProductService() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable("id") Long id) {
        Optional<ProductEntity> productById = productService.getProductById(id);

        return productById.map(productEntity -> new ResponseEntity<>(productEntity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity productEntity) {
        return new ResponseEntity<>(productService.save(productEntity), HttpStatus.OK);
    }
}
