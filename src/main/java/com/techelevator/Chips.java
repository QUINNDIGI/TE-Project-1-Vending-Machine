package com.techelevator;

public class Chips extends Product {
    public Chips(String name, int price) {
        super(name, price);
    }

    @Override
    public String getSound() {
        return "Crunch Crunch, Yum!";
    }
}
