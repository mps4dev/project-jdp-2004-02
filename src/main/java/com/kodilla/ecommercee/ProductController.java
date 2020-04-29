package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<GenericEntity> getProducts() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public GenericEntity getProduct(Long productId) {
        return new GenericEntity("test value");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProduct")
    public void createProduct(GenericEntity genericEntity) {

    }

    @RequestMapping(method = RequestMethod.POST, value = "updateProduct")
    public GenericEntity updateProduct(GenericEntity genericEntity) {
        return new GenericEntity("Updated Value");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(Long productId) {

    }
}
