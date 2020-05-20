package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @GetMapping
    public List<ProductDto> getAll() {
        return new ArrayList<>();
    }

    @GetMapping("/{productId}")
    public ProductDto get(@PathVariable long productId) {
        return new ProductDto ();
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) {
        return new ProductDto();
    }

    @PutMapping
    public ProductDto update(@RequestBody ProductDto product) {
        return new ProductDto();
    }

    @DeleteMapping("/{productId}")
    public boolean delete(@PathVariable long productId) {
        return true;
    }
}
