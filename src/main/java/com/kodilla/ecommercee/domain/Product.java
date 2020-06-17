package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "PRODUCTS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product extends GenericEntity {

    @NotBlank
    @Column(name = "PRODUCT_NAME")
    private String productName;

    @NotNull
    @Column(name = "PRICE")
    private double productPrice;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID")
    private Group group = new Group();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CART_ID")
    private Cart cart = new Cart();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order = new Order();
}