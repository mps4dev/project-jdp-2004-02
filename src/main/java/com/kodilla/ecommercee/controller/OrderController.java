package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.model.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping()
    public List<OrderDto> get() {
        return new ArrayList<>();
    }

    @GetMapping("/{orderId}")
    public OrderDto get(@PathVariable Long orderId) {
        return new OrderDto(1L,"Get order");
    }

    @DeleteMapping("/{orderId}")
    public void delete(@PathVariable Long orderId) {

    }

    @PostMapping()
    public OrderDto update(@RequestBody OrderDto orderDto) {
        return new OrderDto(1L, "Updated order");
    }

    @PutMapping()
    public void create(@RequestBody OrderDto orderDto) {

    }
}