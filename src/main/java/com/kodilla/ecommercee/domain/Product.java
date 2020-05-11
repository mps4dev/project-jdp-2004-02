package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.GenericEntity;
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

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "JOIN_PRODUCTS_CARTS",
            inverseJoinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "ID")},
            joinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")}
    )
    private List<Cart> carts;
}



