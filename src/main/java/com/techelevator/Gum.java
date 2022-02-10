package com.techelevator;

public class Gum extends Product {
    public Gum(String name, int price) {
        super(name, price);
    }

    @Override
    public String getSound() {
        return "Chew, Chew Yum!";
    }
}
