package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class VendingMachine {

   private int customerBalance = 0;
   private int machineBalance = 0;
   private Inventory inventory = new Inventory();

    public Inventory getInventory() {
        return inventory;
    }

    public int feedMoney (int dollars) {
// TODO: write tests
        customerBalance += dollars * 100;
        return customerBalance;

    }
    public int getChange() {
        // TODO: write tests
        int moneyToReturn = customerBalance;
        customerBalance = 0;
        return moneyToReturn;
    }

    public Product selectProduct(String location) {
        TreeMap<String, Product> map = inventory.getInventory();
       Product product = map.get(location);
// check to see if location is valid (if product is null not in map)
 // check to see if sold out (product.getcount < 1 )
 // check to see if enough $$(customer balance is >= item.getprice)
 // deduct cost of product from customer balance
 // reduce the product.count by 1 (maybe setter or another method on product class to reduce count (--count)




       return product;


    }








}
