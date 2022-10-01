package org.example;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productList;

    public ProductRepository() {

    }

    @PostConstruct
    public void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product(1, "Milk", 75),
                new Product(2, "Salt", 10000),
                new Product(3, "Butter", 130),
                new Product(4, "Bread", 25),
                new Product(5, "Alenka", 80)
        ));
    }

    public Product findById(Long id) {
        return productList.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

    public List<Product> getAll() {
        return productList;
    }
}
