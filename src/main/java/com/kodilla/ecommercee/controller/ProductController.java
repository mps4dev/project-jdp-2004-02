package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public ProductDto get(@PathVariable Long productId) {
        return productService.get(productId);
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) {
        return productService.create(productDto);
    }

    @PutMapping
    public ProductDto update(@RequestBody ProductDto productDto) {
        return productService.update(productDto);
    }

    @DeleteMapping("/{productId}")
    public boolean delete(@PathVariable Long productId) {
        return productService.delete(productId);
    }
}
