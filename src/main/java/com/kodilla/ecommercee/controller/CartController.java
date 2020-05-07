package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @PostMapping
    public void create(@RequestBody CartDto cartDto) {

    }

    @GetMapping("/{cartId}")
    public ProductDto getProduct(@RequestParam long productId, @PathVariable long cartId) {
        return new ProductDto();
    }

    @GetMapping("/{cartId}/products")
    public List<ProductDto> getAllProducts(@PathVariable long cartId) {
    return new ArrayList<>();
    }

    @PostMapping("/{cartId}")
    public void addProduct(@RequestParam long productId, @PathVariable long cartId) {

    }

    @DeleteMapping("/{cartId}")
    public void deleteProduct(@RequestParam long productId, @PathVariable long cartId) {

    }

    @PutMapping("/makeOrder")
    public OrderDto makeOrder(@RequestBody CartDto cartDto) {
        return new OrderDto();
    }
}


