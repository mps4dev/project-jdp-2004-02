package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTest {

    @Autowired
    private CartRepository cartRepository;

    private Cart cart = new Cart();
    private List<Product> products = new LinkedList<>();

    @After
    public void after() {
        cartRepository.deleteAll();
    }

    @Test
    public void userTest() {
        //Given
        List<Order> orders = new ArrayList<>();
        User user = new User("UserName", false, orders, cart);
        cart.setUser(user);
        cartRepository.save(cart);

        //When
        Cart savedCart = cartRepository.findById(cart.getId())
                .orElseThrow(() -> new RuntimeException());

        //Then
        assertEquals("UserName", savedCart.getUser().getName());
    }

    @Test
    public void createCartAndZeroProducts() {
        //Given
        cart.setProducts(products);
        cartRepository.save(cart);

        //When
        Cart savedCart = cartRepository.findById(cart.getId())
                .orElseThrow(() -> new RuntimeException());

        //Then
        assertEquals(0, savedCart.getProducts().size());
        assertNotNull(cart);
    }

    @Test
    public void createCartAndTwoProducts() {
        //Given
        products.add(new Product("test1", 1.0, null, null, null));
        products.add(new Product("test2", 2.0, null, null, null));
        cart.setProducts(products);
        cartRepository.save(cart);

        //When
        Cart savedCart = cartRepository.findById(cart.getId())
                .orElseThrow(() -> new RuntimeException());

        //Then
        assertEquals(2, savedCart.getProducts().size());
    }

    @Test
    public void updateCart() {
        //Given
        products.add(new Product("test1", 1.0, null, null, null));
        cart.setProducts(products);
        cartRepository.save(cart);

        //When
        products.remove(0);
        products.add(new Product("test2", 2.0, null, null, null));
        cart.setProducts(products);
        cartRepository.save(cart);
        Cart updatedCart = cartRepository.findById(cart.getId())
                .orElseThrow(() -> new RuntimeException());

        //Then
        assertEquals("test2", updatedCart.getProducts().get(0).getProductName());
    }

    @Test
    public void emptyCart() {
        //Given
        products.add(new Product("test1", 1.0, null, null, null));
        cart.setProducts(products);
        cartRepository.save(cart);

        //When
        cartRepository.delete(cart);

        //Then
        assertFalse(cartRepository.existsById(cart.getId()));
    }
}
