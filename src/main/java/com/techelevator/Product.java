package com.techelevator;

import java.util.TreeMap;

public abstract class Product {

    private String name;
    private int price;
    private int inventoryQuantity = 5;


    public Product(String name, int price) {
        this.name = name;
        this.price = price;

    }
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    public int getInventory() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public int reduceInventory() {
        inventoryQuantity--;
        return inventoryQuantity;

    }
    public abstract String getSound();

}
