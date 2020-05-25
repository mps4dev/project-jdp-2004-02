package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.OrderRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {
    @Autowired
    private OrderRepository orderRepository;

    private Order order = new Order();
    private User user = new User();
    private List<Product> products = new ArrayList<>();
    private Product product = new Product();

    @Before
    public void beforeTest() {
        products.add(product);

        user.setName("user");

        order.setProducts(products);
        order.setUser(user);

        orderRepository.save(order);
    }

    @After
    public void afterTest() {
        orderRepository.delete(order);
    }

    @Test
    public void shouldCreateAndReadOrder() {
        //When
        Order savedOrder = orderRepository.findById(order.getId()).get();

        //Then
        List<Product> savedProducts = savedOrder.getProducts();
        User savedUser = savedOrder.getUser();

        assertEquals(1, savedProducts.size());
        assertEquals("user", savedUser.getName());
    }

    @Test
    public void shouldUpdateOrder() {
        //When
        Order savedOrder = orderRepository.findById(order.getId()).get();

        products.add(product);
        user.setName("update");

        savedOrder.setProducts(products);
        savedOrder.setUser(user);

        Order updatedOrder = orderRepository.save(savedOrder);

        //Then
        List<Product> updatedProducts = updatedOrder.getProducts();
        User updatedUser = updatedOrder.getUser();

        assertEquals(2, updatedProducts.size());
        assertEquals("update", updatedUser.getName());
    }

    @Test
    public void shouldDeleteOrder() {
        //When
        orderRepository.delete(order);

        //Then
        boolean isDeleted = orderRepository.existsById(order.getId());

        assertFalse(isDeleted);
    }
}


