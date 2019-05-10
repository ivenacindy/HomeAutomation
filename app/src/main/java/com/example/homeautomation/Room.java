package com.example.homeautomation;

public class Room {
    private String name;
    private int image;

    public Room(String name, int image) {
        this.name = name;
        this.image = image;
    }
    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}