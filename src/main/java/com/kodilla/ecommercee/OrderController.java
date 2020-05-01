package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
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

    @PostMapping()
    public OrderDto update(@RequestBody OrderDto orderDto) {
        return new OrderDto();
    }

    @PutMapping()
    public void create(@RequestBody OrderDto orderDto) {

    }
}