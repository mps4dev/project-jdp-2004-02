package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {
    @Autowired
    private ProductRepository productRepository;

    private Product product = new Product();
    private Order order = new Order();
    private Cart cart = new Cart();
    private Group group = new Group();
    private User user = new User();


    @Before
    public void beforeTest() {
        group.setName("group");
        user.setName("user");
        cart.setUser(user);
        order.setUser(user);

        product.setOrder(order);
        product.setCart(cart);
        product.setGroup(group);

        productRepository.save(product);
    }

    @After
    public void afterTest() {
        productRepository.delete(product);
    }

    @Test
    public void shouldCreateAndReadProduct() {
        //When
        Product savedProduct = productRepository.findById(product.getId()).get();

        //Then
        Group savedGroup = savedProduct.getGroup();
        Cart savedCart = savedProduct.getCart();
        Order savedOrder = savedProduct.getOrder();

        assertEquals("user", savedCart.getUser().getName());
        assertEquals("user", savedOrder.getUser().getName());
        assertEquals("group", savedGroup.getName());
    }

    @Test
    public void shouldUpdateProduct() {
        //When
        Product savedProduct = productRepository.findById(product.getId()).get();

        group.setName("update");
        user.setName("update");
        cart.setUser(user);
        order.setUser(user);

        savedProduct.setGroup(group);
        savedProduct.setCart(cart);
        savedProduct.setOrder(order);

        Product updatedProduct = productRepository.save(savedProduct);

        //Then
        Cart updatedCart = updatedProduct.getCart();
        Group updatedGroup = updatedProduct.getGroup();
        Order updatedOrder = updatedProduct.getOrder();

        assertEquals("update", updatedCart.getUser().getName());
        assertEquals("update", updatedGroup.getName());
        assertEquals("update", updatedOrder.getUser().getName());
    }

    @Test
    public void shouldDeleteProduct() {
        //When
        productRepository.delete(product);

        //Then
        boolean isDeleted = productRepository.existsById(product.getId());

        assertFalse(isDeleted);
    }
}


