package com.example.recycleandcard;

public class Product {
    private String title;
    private int image;

    public Product(String title, int image) {
        this.title = title;
        this.image = image;
    }
    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
}