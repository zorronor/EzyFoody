package com.example.ezyfoody;

import java.io.Serializable;

public class Food implements Serializable {
    String name;
    int price;
    int thumbnail;
    int quantity = 0;
    int id;

    public Food(String name, int price, int thumbnail, int quantity, int id) {
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
        this.quantity = quantity;
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {return id; }

    public void setId(int id) {this.id = id; }
}


