package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @GetMapping
    public List<OrderDto> getAll() {
        return new ArrayList<>();
    }

    @GetMapping("/{orderId}")
    public OrderDto get(@PathVariable Long orderId) {
        return new OrderDto();
    }

    @DeleteMapping("/{orderId}")
    public void delete(@PathVariable Long orderId) {

    }

    @PutMapping
    public OrderDto update(@RequestBody OrderDto orderDto) {
        return new OrderDto();
    }

    @PostMapping
    public void create(@RequestBody OrderDto orderDto) {

    }
}