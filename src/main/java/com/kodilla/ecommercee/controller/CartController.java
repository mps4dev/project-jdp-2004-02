package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping
    public CartDto create(@RequestBody CartDto cartDto) {
        return cartService.create(cartDto);
    }

    @GetMapping("/{cartId}")
    public ProductDto getProduct(@RequestParam long productId, @PathVariable long cartId) {
        return cartService.getProduct(productId, cartId);
    }

    @GetMapping("/{cartId}/products")
    public List<ProductDto> getAllProducts(@PathVariable long cartId) {
        return cartService.getAllProducts(cartId);
    }

    @PostMapping("/{cartId}")
    public boolean addProduct(@RequestParam long productId, @PathVariable long cartId) {
        return cartService.addProduct(productId, cartId);
    }

    @DeleteMapping("/{cartId}")
    public boolean deleteProduct(@RequestParam long productId, @PathVariable long cartId) {
        return cartService.deleteProduct(productId, cartId);
    }

    @PutMapping("/makeOrder")
    public OrderDto makeOrder(@RequestBody CartDto cartDto) {
        return cartService.makeOrder(cartDto);
    }
}