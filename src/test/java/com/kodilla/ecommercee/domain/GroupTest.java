package com.kodilla.ecommercee.domain;


import com.kodilla.ecommercee.repository.GroupRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupTest {

    @Autowired
    private GroupRepository groupRepository;

    @After
    public void cleanUp() {
        groupRepository.deleteAll();
    }

    @Test
    public void createRead() {
        // Given
        Group group = createSavedGroup();

        // When
        Group foundGroup = groupRepository
                .findById(group.getId())
                .orElseThrow(() -> new RuntimeException());

        // Then
        assertEquals("name", foundGroup.getName());
        assertEquals("description", foundGroup.getDescription());
        assertEquals(2, foundGroup.getProducts().size());
    }

    @Test
    public void update() {
        // Given
        Group group = createSavedGroup();

        // When
        List<Product> newProducts = new LinkedList<>();
        newProducts.add(createProduct());

        group.setName("updated name");
        group.setDescription("updated description");
        group.setProducts(newProducts);

        Group updatedGroup = groupRepository.save(group);

        // Then
        assertEquals("updated name", updatedGroup.getName());
        assertEquals("updated description", updatedGroup.getDescription());
        assertEquals(1, updatedGroup.getProducts().size());
    }

    @Test
    public void delete() {
        // Given
        Group group = createSavedGroup();

        // When
        groupRepository.delete(group);

        // Then
        assertFalse(groupRepository.existsById(group.getId()));
    }

    private Group createSavedGroup() {
        Group group = new Group();
        group.setName("name");
        group.setDescription("description");

        List<Product> products = new LinkedList<>();
        products.add(createProduct());
        products.add(createProduct());
        group.setProducts(products);

        return groupRepository.save(group);
    }

    private Product createProduct() {
        return new Product("test", 1.0, null, null, null);
    }
}
