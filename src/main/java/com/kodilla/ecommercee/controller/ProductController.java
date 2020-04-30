package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.model.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @GetMapping(value = "getAll")
    public List<ProductDto> getAll() {
        return new ArrayList<>();
    }

    @GetMapping("/{productId}")
    public ProductDto get(@PathVariable long productId) {
        return new ProductDto ();
    }

    @PutMapping()
    public void create(@RequestBody ProductDto productDto) {

    }

    @PostMapping()
    public ProductDto update(@RequestBody ProductDto product) {
        return new ProductDto();
    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable long productId) {

    }
}
