package com.kodilla.ecommercee.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartId;
    private Product product;
    private double productQuantity;
    private double sum;

    @OneToMany(targetEntity = Product.class,
               mappedBy = "cart",
               fetch = FetchType.LAZY)
    private List<Product> cartContent = new ArrayList<>();

    public Cart(Product product, double productQuantity) {
        this.productQuantity = productQuantity;
        this.sum = product.getProductPrice()*productQuantity;
    }
}
