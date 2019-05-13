package com.example.homeautomation;

public class Room {
    private String name;
    private int status;

    public Room(String name, int status) {
        this.status = status;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }
}