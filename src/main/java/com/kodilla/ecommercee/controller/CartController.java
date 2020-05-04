package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.model.CartDto;
import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {
    List<ProductDto> products = new ArrayList<>();

    @PutMapping
    public void create(@RequestBody CartDto cartDto) {

    }

    @GetMapping("/{productId}")
    public ProductDto getProduct(@PathVariable long productId) {
        return new ProductDto();
    }

    @PostMapping("/{productId}")
    public void addProduct(@PathVariable long productId) {

    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable long productId) {

    }

    @PutMapping
    public void makeOrder(@RequestBody CartDto cartDto) {

    }
}


