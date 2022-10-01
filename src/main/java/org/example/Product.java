package org.example;

import org.springframework.stereotype.Component;

@Component
public class Product {
    private Long id;
    private String title;
    private int cost;

    public Product() {

    }

    public Product(long id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCost() {
        return cost;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getString() {
        return "Id: " + id + "     Title: " + title + "     Cost: " + cost;
    }
}
