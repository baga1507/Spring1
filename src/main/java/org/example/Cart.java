package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Scope("prototype")
public class Cart {
    private List<Product> cartList;
    private ProductRepository productRepository;

    @PostConstruct
    public void init() {
        cartList = new ArrayList<Product>(Arrays.asList());
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addToCart(Long id) {
        cartList.add(productRepository.findById(id));
    }

    public void discardFromCart(Long id) {
        cartList.remove(productRepository.findById(id));
    }

    public void printProducts() {
        for (Product product: productRepository.getAll())
            System.out.println(product.getString());
    }

    public void printCartList() {
        for (Product product: cartList)
            System.out.println(product.getString());
    }
}
