package com.techelevator;

public class Drink extends Product{
    public Drink(String name, int price) {
        super(name, price);
    }

    @Override
    public String getSound() {
        return "Glug, Glug Yum!";
    }
}
