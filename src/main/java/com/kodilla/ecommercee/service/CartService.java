package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final OrderRepository orderRepository;

    public CartDto create(final CartDto cartDto) {
        Cart cart = cartMapper.mapToEntity(cartDto);    // mapuję cartDto na cart
        Cart saveCart = cartRepository.save(cart);      // zapis cart do repo

        return cartMapper.mapToDto(saveCart);
    }

    public List<ProductDto> getAllProducts(final long cartId) {
        Cart cart = cartRepository.getOne(cartId);      // pobieram z repo koszyk o id
        List<Product> products = cart.getProducts();    // pobieram listę produktów

        return productMapper.mapToDtos(products);
    }

    public boolean addProduct(final long productId, final long cartId) {
        Product product = productRepository.getOne(productId);  // tworzę produkt o id productId zgodnie z repo produkt
        Cart cart = cartRepository.getOne(cartId);              // pobieram z repo koszyk o id
        List<Product> products = cart.getProducts();            // pobieram wszystkie produkty z koszyka
        products.add(product);                                  // dodaję produkt do listy produktów
        cart.setProducts(products);                             // podmieniam listę produktów w koszyku na powiększoną o produkt
        cartRepository.save(cart);                              // zapis koszyka do repo

        return true;
    }

    public ProductDto getProduct(final long productId, final long cartId) {
        Cart cart = cartRepository.getOne(cartId);                  // pobieram koszyk z repo
        List<Product> products = cart.getProducts();                // pobieram listę produktów
        Product product = productRepository.getOne(productId);      // wybieram produkt z repo

        for (Product getProduct : products) {
            if(getProduct.equals(product))
                return productMapper.mapToDto(product);             // jeśli na liście istnieje produkt to zwróć -> przerobić na stream
        }
        return new ProductDto();                                    // niezbyt eleganckie, jeśli nie ma na liście
    }

    public boolean deleteProduct(final long productId, final long cartId) {
        Cart cart = cartRepository.getOne(cartId);              // pobieram koszyk z repo
        List<Product> products = cart.getProducts();            // pobieram produkty z koszyka
        Product product = productRepository.getOne(productId);  // pobieram produkt z repo do porównania
        if(products.contains(product)) {
            products.remove(product);                           // usuwam produkt z listy
            cart.setProducts(products);                         // podmieniam w koszyku listę produktów na zmniejszoną o produkt
            cartRepository.save(cart);                          // zapisuję koszyk do repo

            return true;
        }
        else {
            return false;
        }
    }

    public OrderDto makeOrder(final CartDto cartDto) {
        cartRepository.deleteById(cartDto.getId());

        return new OrderDto();                          // tymczasowo zwracam pusty DTO, czekam na CartController
    }
}
