package com.techelevator;

public class Candy extends Product
{
    public Candy(String name, int price) {
        super(name, price);
    }

    @Override
    public String getSound() {
        return "Munch, Munch Yum!";
    }
}
